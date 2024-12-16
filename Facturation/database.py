from motor.motor_asyncio import AsyncIOMotorClient

# URL de connexion MongoDB
MONGO_URL = "mongodb://localhost:27017"

# Connexion au client MongoDB avec motor
client = AsyncIOMotorClient(MONGO_URL)

# Base de données et collection des factures
db = client["facturation_db"]
facture_collection = db["factures"]