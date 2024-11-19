from extensions import db

class Chambre(db.Model):
    __tablename__ = 'chambres'

    id = db.Column(db.Integer, primary_key=True)
    numero = db.Column(db.String(50), unique=True, nullable=False)
    type_chambre = db.Column(db.String(100), nullable=False)
    prix = db.Column(db.Float, nullable=False)
    disponible = db.Column(db.Boolean, default=True)

    def __init__(self, numero, type_chambre, prix, disponible=True):
        self.numero = numero
        self.type_chambre = type_chambre
        self.prix = prix
        self.disponible = disponible

    def to_dict(self):
        return {
            "id": self.id,
            "numero": self.numero,
            "type_chambre": self.type_chambre,
            "prix": self.prix,
            "disponible": self.disponible,
        }
