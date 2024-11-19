from flask import Flask
from extensions import db
from controller.chambre_controller import chambre_routes

app = Flask(__name__)

# Configuration de la base de données
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:@localhost:3306/chambre_db'

app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db.init_app(app)  # Initialiser SQLAlchemy avec Flask

# Enregistrer les blueprints
app.register_blueprint(chambre_routes)


# Initialiser la base de données (uniquement en développement)
with app.app_context():
    db.create_all()
    print("Tables créées avec succès !")


if __name__ == '__main__':
    app.run(debug=True)
