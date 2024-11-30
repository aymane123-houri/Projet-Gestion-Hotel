from mongoengine import Document, StringField, IntField, DateField, ReferenceField, EmbeddedDocument, \
    EmbeddedDocumentField


class Reservation(EmbeddedDocument):
    date_debut = StringField(required=True)
    date_fin = StringField(required=True)
    montant_total = IntField(required=True)


class Facture(Document):
    meta = {'collection': 'factures'}  # Specify the collection name

    id = IntField(primary_key=True)  # Unique identifier
    reservation_id = IntField(required=True)  # Foreign key-like field
    date_facturation = DateField(required=True)  # Invoice date
    montant_total = IntField(required=True)  # Total amount
    statut = StringField(max_length=50, required=True)  # Status of the invoice
    reservation = EmbeddedDocumentField(Reservation)
