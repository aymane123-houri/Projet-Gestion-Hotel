import graphene
from bson import ObjectId
from database import facture_collection  # Assurez-vous que `facture_collection` est bien défini dans `database.py`

from grpcClient import GrpcReservationClient


# Définition du type Facture
class UserType(graphene.ObjectType):
    nom = graphene.String()
    prenom = graphene.String()
    email = graphene.String()
    telephone = graphene.String()
    adresse = graphene.String()
    cni = graphene.String()


class ChambreType(graphene.ObjectType):
    numero = graphene.String()
    prix = graphene.Float()


class ReservationType(graphene.ObjectType):
    date_debut = graphene.String()
    date_fin = graphene.String()
    montant_total = graphene.Float()
    user = graphene.Field(UserType)
    chambre = graphene.Field(ChambreType)


class FactureType(graphene.ObjectType):
    id = graphene.String()  # Le champ id sera utilisé pour stocker l'ID MongoDB sous forme de chaîne
    reservation_id = graphene.String()
    date_facturation = graphene.String()
    montant_total = graphene.Float()
    statut = graphene.String()
    reservation = graphene.Field(ReservationType)


# Requêtes GraphQL
class Query(graphene.ObjectType):
    all_factures = graphene.List(FactureType)
    facture = graphene.Field(FactureType, id=graphene.String(required=True))

    # Résolution de la requête pour obtenir toutes les factures
    async def resolve_all_factures(self, info):
        factures_cursor = facture_collection.find()  # Requête asynchrone
        factures = await factures_cursor.to_list(length=None)  # Convertir le curseur en liste
        return [
            FactureType(
                id=str(facture['_id']),  # Convertir ObjectId en string
                reservation_id=facture['reservation_id'],
                date_facturation=facture['date_facturation'],
                montant_total=facture['montant_total'],
                statut=facture['statut'],
                reservation=facture['reservation']

            )
            for facture in factures
        ]

    # Résolution de la requête pour obtenir une facture par ID
    async def resolve_facture(self, info, id):
        facture = await facture_collection.find_one({"_id": ObjectId(id)})  # Requête asynchrone
        reservation_data = facture.get('reservation')
        if facture:
            return FactureType(
                id=str(facture['_id']),
                reservation_id=facture['reservation_id'],
                date_facturation=facture['date_facturation'],
                montant_total=facture['montant_total'],
                statut=facture['statut'],
                reservation=facture['reservation']
            )
        return None


# Mutation pour créer une facture
class CreateFacture(graphene.Mutation):
    class Arguments:
        reservation_id = graphene.String(required=True)
        date_facturation = graphene.String(required=True)
        montant_total = graphene.Float(required=True)
        statut = graphene.String(required=True)

    facture = graphene.Field(FactureType)

    async def mutate(self, info, reservation_id, date_facturation, montant_total, statut):
        # Récupérer la réservation via gRPC
        reservation = GrpcReservationClient.getReservation(reservation_id)

        if reservation is None:
            raise Exception("Reservation not found")

            # Créer la facture dans la base de données
        facture_data = {
            "reservation_id": reservation_id,
            "date_facturation": date_facturation,
            "montant_total": montant_total,
            "statut": statut,
            "reservation": GrpcReservationClient.getReservation(reservation_id)
        }
        result = await facture_collection.insert_one(facture_data)
        facture_data["id"] = str(result.inserted_id)  # Ajouter l'ID MongoDB sous forme de string
        return CreateFacture(facture=FactureType(id=facture_data["id"],
                                                 reservation_id=facture_data["reservation_id"],
                                                 date_facturation=facture_data["date_facturation"],
                                                 montant_total=facture_data["montant_total"],
                                                 statut=facture_data["statut"],
                                                 reservation=facture_data["reservation"]
                                                 ))


# Mutation pour mettre à jour une facture
class UpdateFacture(graphene.Mutation):
    class Arguments:
        id = graphene.String(required=True)
        reservation_id = graphene.String()
        date_facturation = graphene.String()
        montant_total = graphene.Float()
        statut = graphene.String()

    facture = graphene.Field(FactureType)

    async def mutate(self, info, id, reservation_id=None, date_facturation=None, montant_total=None, statut=None):
        # Mettre à jour la facture dans la base de données
        update_data = {}
        if reservation_id:
            update_data["reservation_id"] = reservation_id
        if date_facturation:
            update_data["date_facturation"] = date_facturation
        if montant_total:
            update_data["montant_total"] = montant_total
        if statut:
            update_data["statut"] = statut

        await facture_collection.update_one({"_id": ObjectId(id)}, {"$set": update_data})
        updated_facture = await facture_collection.find_one({"_id": ObjectId(id)})

        return UpdateFacture(
            facture=FactureType(
                id=str(updated_facture['_id']),
                reservation_id=updated_facture['reservation_id'],
                date_facturation=updated_facture['date_facturation'],
                montant_total=updated_facture['montant_total'],
                statut=updated_facture['statut']
            )
        )


# Mutation pour supprimer une facture
class DeleteFacture(graphene.Mutation):
    class Arguments:
        id = graphene.String(required=True)

    success = graphene.Boolean()

    async def mutate(self, info, id):
        result = await facture_collection.delete_one({"_id": ObjectId(id)})
        return DeleteFacture(success=result.deleted_count > 0)


class MarkFactureAsPaid(graphene.Mutation):
    class Arguments:
        id = graphene.String(required=True)  # ID de la facture à mettre à jour

    facture = graphene.Field(FactureType)

    async def mutate(self, info, id):
        # Mise à jour du statut de la facture
        await facture_collection.update_one(
            {"_id": ObjectId(id)},
            {"$set": {"statut": "payée"}}
        )
        updated_facture = await facture_collection.find_one({"_id": ObjectId(id)})
        return MarkFactureAsPaid(
            facture=FactureType(
                id=str(updated_facture['_id']),
                reservation_id=updated_facture['reservation_id'],
                date_facturation=updated_facture['date_facturation'],
                montant_total=updated_facture['montant_total'],
                statut=updated_facture['statut']
            )
        )


# Définition des mutations GraphQL
class Mutation(graphene.ObjectType):
    create_facture = CreateFacture.Field()
    update_facture = UpdateFacture.Field()
    delete_facture = DeleteFacture.Field()
    mark_facture_as_paid = MarkFactureAsPaid.Field()


# Schéma GraphQL
schema = graphene.Schema(query=Query, mutation=Mutation)
