import grpc

from proto import reservation_pb2, reservation_pb2_grpc
from model.Reservation import Reservation


def getReservation(reservation_id):
    # Create a channel to the Spring Boot gRPC server
    channel = grpc.insecure_channel('localhost:9090')

    # Create a stub (client)
    stub = reservation_pb2_grpc.ReservationServiceStub(channel)

    # Prepare the request

    reservation_request = reservation_pb2.ReservationByIdRequest(reservation_id=int(reservation_id))

    # Call the service method
    try:
        response = stub.GetReservationById(reservation_request)
        print(f"Reservation Details:\n"
              f"ID: {response.id}\n")
        return Reservation.getReservation(response.date_debut, response.date_fin, response.montant_total,
                                          response.user.nom, response.user.prenom, response.user.email, response.user.telephone, response.user.adresse, response.user.cni,
                                          response.chambre.numero, response.chambre.prix)
    except grpc.RpcError as e:
        print(f"gRPC Error: {e}")
    finally:
        # Close the channel
        channel.close()
