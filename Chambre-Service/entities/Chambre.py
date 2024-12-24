import base64

from extensions import db,db_reservation



class Chambre(db.Model):
    __tablename__ = 'chambre'

    id = db.Column(db.Integer, primary_key=True)
    numero = db.Column(db.String(50), unique=True, nullable=False)
    nombre_lits = db.Column(db.Integer, nullable=False)
    prix = db.Column(db.Float, nullable=False)
    image = db.Column(db.LargeBinary)
    description = db.Column(db.String(1000))
    adulte_capacite=db.Column(db.Integer, nullable=False)
    enfant_capacite=db.Column(db.Integer, nullable=False)
    type_lits = db.Column(db.String(100), nullable=False)
    disponible = db.Column(db.Boolean, default=True)


    def __init__(self, numero, nombre_lits, prix, image, description, adulte_capacite,enfant_capacite,type_lits, disponible=True):
        self.numero = numero
        self.nombre_lits = nombre_lits
        self.prix = prix
        self.image = image
        self.description = description
        self.adulte_capacite=adulte_capacite
        self.enfant_capacite=enfant_capacite
        self.type_lits = type_lits
        self.disponible = disponible



    def to_dict(self):
       """ return {
            "id": self.id,
            "numero": self.numero,
            "nombre_lits": self.nombre_lits,
            "prix": self.prix,
            "image": self.image,
            "description": self.description,
            "adulte_capacite":self.adulte_capacite,
            "enfant_capacite":self.enfant_capacite,
            "type_lits": self.type_lits,
            "disponible": self.disponible,
        }"""
       image_data = None
       if self.image:
           image_data = base64.b64encode(self.image).decode('utf-8')

       return {
           "id": self.id,
           "numero": self.numero,
           "nombre_lits": self.nombre_lits,
           "prix": self.prix,
           "image": image_data,  # Image sous forme de chaîne base64
           "description": self.description,
           "adulte_capacite":self.adulte_capacite,
           "enfant_capacite":self.enfant_capacite,
           "type_lits":self.type_lits,
           "disponible": self.disponible,

       }


    @staticmethod
    def find_available_chambres(date_debut, date_fin, adults):
        query = text("""
            SELECT c.*
            FROM chambres c
            WHERE c.id NOT IN (
                SELECT r.chambre_id
                FROM reservation r
                WHERE (r.date_debut <= :date_fin AND r.date_fin >= :date_debut)
            )
            AND c.nombre_lits >= :adults
        """)
        result = db.session.execute(query, {
            'date_debut': date_debut,
            'date_fin': date_fin,
            'adults': adults
        })
        return result.fetchall()

