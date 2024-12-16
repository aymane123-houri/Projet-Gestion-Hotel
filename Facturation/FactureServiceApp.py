from fastapi import FastAPI
from starlette_graphene3 import GraphQLApp
from graphene import Schema
from grpcClient import GrpcReservationClient
from py_eureka_client.eureka_client import EurekaClient
import asyncio

from graphql_schemas import Query, Mutation  # Remplacer par le bon chemin

app = FastAPI()

# Schéma GraphQL
app.add_route("/graphql", GraphQLApp(schema=Schema(query=Query, mutation=Mutation)))


@app.get("/")
def read_root():
    return {"message": "Microservice de facturation prêt!"}

eureka_client = EurekaClient(
    eureka_server="http://localhost:8761/eureka/",  # URL du serveur Eureka
    app_name="facture-service",  # Nom de votre microservice
    instance_port=8000,  # Port de votre service
    instance_ip="127.0.0.1",  # Adresse IP de votre instance
    region="default",  # Région (facultatif)
)


# Enregistrement automatique auprès de Eureka
async def start_eureka_client():
    await eureka_client.start()


# Lancer le serveur
if __name__ == "__main__":
    import uvicorn

    asyncio.run(start_eureka_client())

    GrpcReservationClient.getReservation(1)

    uvicorn.run(app, host="0.0.0.0", port=8000)
