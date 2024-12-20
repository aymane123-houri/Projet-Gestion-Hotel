from flask import Flask
from extensions import db
from controller.chambre_controller import chambre_routes
from py_eureka_client.eureka_client import EurekaClient
import asyncio
from flask_cors import CORS
import os
app = Flask(__name__)
CORS(app)
# Configuration de la base de données
#app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root@localhost:3306/chambre_db'
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql+pymysql://root@mysql-service:3306/chambre_db'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db.init_app(app)  # Initialiser SQLAlchemy avec Flask

# Enregistrer les blueprints
app.register_blueprint(chambre_routes)
eureka_server_url = os.getenv('DISCOVERY_SERVICE_URL', 'http://localhost:8761/eureka/')
eureka_client = EurekaClient(
    #eureka_server="http://localhost:8761/eureka/",  # URL du serveur Eureka
    eureka_server=eureka_server_url,
    app_name="chambre-service",  # Nom de votre microservice
    instance_port=5000,  # Port de votre service
    instance_ip="127.0.0.1",  # Adresse IP de votre instance
    region="default",  # Région (facultatif)
)


# Enregistrement automatique auprès de Eureka
async def start_eureka_client():
    await eureka_client.start()


# Initialiser la base de données (uniquement en développement)
with app.app_context():
    db.create_all()
    print("Tables créées avec succès !")

if __name__ == '__main__':

    asyncio.run(start_eureka_client())

    app.run(debug=True)
