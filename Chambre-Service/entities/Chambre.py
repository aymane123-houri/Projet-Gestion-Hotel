import base64

from extensions import db


class Chambre(db.Model):
    __tablename__ = 'chambre'

    id = db.Column(db.Integer, primary_key=True)
    numero = db.Column(db.String(50), unique=True, nullable=False)
    nombre_lits = db.Column(db.Integer, nullable=False)
    prix = db.Column(db.Float, nullable=False)
    image = db.Column(db.LargeBinary)
    description = db.Column(db.String(1000))
    disponible = db.Column(db.Boolean, default=True)

    def __init__(self, numero, nombre_lits, prix, image, description, disponible=True):
        self.numero = numero
        self.nombre_lits = nombre_lits
        self.prix = prix
        self.image = image
        self.description = description
        self.disponible = disponible

    def to_dict(self):
        return {
            "id": self.id,
            "numero": self.numero,
            "nombre_lits": self.nombre_lits,
            "prix": self.prix,
            "image": self.image,
            "description": self.description,
            "disponible": self.disponible,
        }
