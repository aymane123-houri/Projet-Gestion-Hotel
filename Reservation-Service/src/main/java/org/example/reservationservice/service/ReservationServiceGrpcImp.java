package org.example.reservationservice.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.reservationservice.entity.Reservation;
import org.example.reservationservice.grpc.ReservationServiceGrpc;
import org.example.reservationservice.grpc.ReservationServiceProto;

import java.util.List;

@GrpcService
public class ReservationServiceGrpcImp extends ReservationServiceGrpc.ReservationServiceImplBase{
    private final ReservationService reservationService;

    public ReservationServiceGrpcImp(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public void createReservation(ReservationServiceProto.CreateReservationRequest request, StreamObserver<ReservationServiceProto.MessageResponse> responseObserver){
        Reservation reservation = new Reservation();
        reservation.setUserId(request.getUserId());
        reservation.setChambreId(request.getChambreId());
        reservation.setDateDebut(request.getDateDebut());
        reservation.setDateFin(request.getDateFin());

        String result = reservationService.CreateReservation(reservation);

        ReservationServiceProto.MessageResponse response = ReservationServiceProto.MessageResponse.newBuilder()
                .setMessage(result)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void updateReservation(ReservationServiceProto.UpdateReservationRequest request, StreamObserver<ReservationServiceProto.MessageResponse> responseObserver){
        Reservation reservation = new Reservation();
        reservation.setId(request.getId());
        reservation.setUserId(request.getUserId());
        reservation.setChambreId(request.getChambreId());
        reservation.setDateDebut(request.getDateDebut());
        reservation.setDateFin(request.getDateFin());
        reservation.setMontant_total(request.getMontantTotal());

        String result = reservationService.UpdateReservaion(reservation);

        ReservationServiceProto.MessageResponse response = ReservationServiceProto.MessageResponse.newBuilder()
                .setMessage(result)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void deleteReservation(ReservationServiceProto.DeleteReservationRequest request, StreamObserver<ReservationServiceProto.MessageResponse> responseObserver){
        Reservation reservation = new Reservation();
        reservation.setId(request.getId());

        String result = reservationService.DeleteReservation(reservation);


        ReservationServiceProto.MessageResponse response = ReservationServiceProto.MessageResponse.newBuilder()
                .setMessage(result)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void getReservationById(ReservationServiceProto.ReservationByIdRequest request, StreamObserver<ReservationServiceProto.ReservationResponse> responseObserver){

        Reservation reservation = reservationService.GetReservaionById(request.getId());
        ReservationServiceProto.User.Builder user = ReservationServiceProto.User.newBuilder();
        ReservationServiceProto.Chambre.Builder chambre = ReservationServiceProto.Chambre.newBuilder();

        if (reservation.getUser().getEmail() == null) {
            user.setNom("null")
                    .setPrenom("null")
                    .setEmail("null")
                    .setTelephone("null")
                    .setAdresse("null")
                    .setCni("null");
        } else {
            user.setNom(reservation.getUser().getNom())
                    .setPrenom(reservation.getUser().getPrenom())
                    .setEmail(reservation.getUser().getEmail())
                    .setTelephone(reservation.getUser().getTelephone())
                    .setAdresse(reservation.getUser().getAdresse())
                    .setCni(reservation.getUser().getCni());
        }
        user.build();

        if (reservation.getChambre().getNumero() == null){
            chambre.setNumero("null")
                    .setNombreLits(0)
                    .setPrix(0)
                    .setImage("null")
                    .setDescription("null")
                    .setDisponible(false);

        } else {
            chambre.setNumero(reservation.getChambre().getNumero())
                    .setNombreLits(reservation.getChambre().getNombre_lits())
                    .setPrix(reservation.getChambre().getPrix())
                    .setImage(reservation.getChambre().getImage())
                    .setDescription(reservation.getChambre().getDescription())
                    .setDisponible(reservation.getChambre().getDisponible());
        }
        chambre.build();


        ReservationServiceProto.ReservationResponse response = ReservationServiceProto.ReservationResponse.newBuilder()
                .setId(reservation.getId())
                .setUserId(reservation.getUserId())
                .setChambreId(reservation.getChambreId())
                .setDateDebut(reservation.getDateDebut())
                .setDateFin(reservation.getDateFin())
                .setMontantTotal(reservation.getMontant_total())
                .setUser(user)
                .setChambre(chambre)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void getReservationByUserId(ReservationServiceProto.ReservationByUserIdRequest request, StreamObserver<ReservationServiceProto.ReservationResponse> responseObserver){

        Reservation reservation = reservationService.GetReservaionByUserId(request.getUserId());
        ReservationServiceProto.User.Builder user = ReservationServiceProto.User.newBuilder();
        ReservationServiceProto.Chambre.Builder chambre = ReservationServiceProto.Chambre.newBuilder();

        if (reservation.getUser().getEmail() == null) {
            user.setNom("null")
                    .setPrenom("null")
                    .setEmail("null")
                    .setTelephone("null")
                    .setAdresse("null")
                    .setCni("null");
        } else {
            user.setNom(reservation.getUser().getNom())
                    .setPrenom(reservation.getUser().getPrenom())
                    .setEmail(reservation.getUser().getEmail())
                    .setTelephone(reservation.getUser().getTelephone())
                    .setAdresse(reservation.getUser().getAdresse())
                    .setCni(reservation.getUser().getCni());
        }
        user.build();

        if (reservation.getChambre().getNumero() == null){
            chambre.setNumero("null")
                    .setNombreLits(0)
                    .setPrix(0)
                    .setImage("null")
                    .setDescription("null")
                    .setDisponible(false);

        } else {
            chambre.setNumero(reservation.getChambre().getNumero())
                    .setNombreLits(reservation.getChambre().getNombre_lits())
                    .setPrix(reservation.getChambre().getPrix())
                    .setImage(reservation.getChambre().getImage())
                    .setDescription(reservation.getChambre().getDescription())
                    .setDisponible(reservation.getChambre().getDisponible());
        }
        chambre.build();

        ReservationServiceProto.ReservationResponse response = ReservationServiceProto.ReservationResponse.newBuilder()
                .setId(reservation.getId())
                .setUserId(reservation.getUserId())
                .setChambreId(reservation.getChambreId())
                .setDateDebut(reservation.getDateDebut())
                .setDateFin(reservation.getDateFin())
                .setMontantTotal(reservation.getMontant_total())
                .setUser(user)
                .setChambre(chambre)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void getReservationByChambreId(ReservationServiceProto.ReservationByChambreIdRequest request, StreamObserver<ReservationServiceProto.ReservationResponse> responseObserver){

        Reservation reservation = reservationService.GetReservationByChambreId(request.getChambreId());
        ReservationServiceProto.User.Builder user = ReservationServiceProto.User.newBuilder();
        ReservationServiceProto.Chambre.Builder chambre = ReservationServiceProto.Chambre.newBuilder();

        if (reservation.getUser().getEmail() == null) {
            user.setNom("null")
                    .setPrenom("null")
                    .setEmail("null")
                    .setTelephone("null")
                    .setAdresse("null")
                    .setCni("null");
        } else {
            user.setNom(reservation.getUser().getNom())
                    .setPrenom(reservation.getUser().getPrenom())
                    .setEmail(reservation.getUser().getEmail())
                    .setTelephone(reservation.getUser().getTelephone())
                    .setAdresse(reservation.getUser().getAdresse())
                    .setCni(reservation.getUser().getCni());
        }
        user.build();

        if (reservation.getChambre().getNumero() == null){
            chambre.setNumero("null")
                    .setNombreLits(0)
                    .setPrix(0)
                    .setImage("null")
                    .setDescription("null")
                    .setDisponible(false);

        } else {
            chambre.setNumero(reservation.getChambre().getNumero())
                    .setNombreLits(reservation.getChambre().getNombre_lits())
                    .setPrix(reservation.getChambre().getPrix())
                    .setImage(reservation.getChambre().getImage())
                    .setDescription(reservation.getChambre().getDescription())
                    .setDisponible(reservation.getChambre().getDisponible());
        }
        chambre.build();

        ReservationServiceProto.ReservationResponse response = ReservationServiceProto.ReservationResponse.newBuilder()
                .setId(reservation.getId())
                .setUserId(reservation.getUserId())
                .setChambreId(reservation.getChambreId())
                .setDateDebut(reservation.getDateDebut())
                .setDateFin(reservation.getDateFin())
                .setMontantTotal(reservation.getMontant_total())
                .setUser(user)
                .setChambre(chambre)
                .build();

        // Send the response back to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void getReservationByDateDebut(ReservationServiceProto.ReservationByDate_DebutRequest request, StreamObserver<ReservationServiceProto.ReservationsResponse> responseObserver){

        List<Reservation> reservations = reservationService.GetReservationByDate_Debut(request.getDate());
        ReservationServiceProto.User.Builder user = ReservationServiceProto.User.newBuilder();
        ReservationServiceProto.Chambre.Builder chambre = ReservationServiceProto.Chambre.newBuilder();

        ReservationServiceProto.ReservationsResponse.Builder response = ReservationServiceProto.ReservationsResponse.newBuilder();

        for (Reservation reservation : reservations) {

            if (reservation.getUser().getEmail() == null) {
                user.setNom("null")
                        .setPrenom("null")
                        .setEmail("null")
                        .setTelephone("null")
                        .setAdresse("null")
                        .setCni("null");
            } else {
                user.setNom(reservation.getUser().getNom())
                        .setPrenom(reservation.getUser().getPrenom())
                        .setEmail(reservation.getUser().getEmail())
                        .setTelephone(reservation.getUser().getTelephone())
                        .setAdresse(reservation.getUser().getAdresse())
                        .setCni(reservation.getUser().getCni());
            }
            user.build();

            if (reservation.getChambre().getNumero() == null){
                chambre.setNumero("null")
                        .setNombreLits(0)
                        .setPrix(0)
                        .setImage("null")
                        .setDescription("null")
                        .setDisponible(false);

            } else {
                chambre.setNumero(reservation.getChambre().getNumero())
                        .setNombreLits(reservation.getChambre().getNombre_lits())
                        .setPrix(reservation.getChambre().getPrix())
                        .setImage(reservation.getChambre().getImage())
                        .setDescription(reservation.getChambre().getDescription())
                        .setDisponible(reservation.getChambre().getDisponible());
            }
            chambre.build();

            ReservationServiceProto.ReservationResponse reservationResponse = ReservationServiceProto.ReservationResponse.newBuilder()
                    .setId(reservation.getId())
                    .setUserId(reservation.getUserId())
                    .setChambreId(reservation.getChambreId())
                    .setDateDebut(reservation.getDateDebut())
                    .setDateFin(reservation.getDateFin())
                    .setMontantTotal(reservation.getMontant_total())
                    .setUser(user)
                    .setChambre(chambre)
                    .build();

            response.addReservations(reservationResponse);
        }

        // Send the response back to the client
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }

    @Override
    public void getAllReservations(ReservationServiceProto.Empty request, StreamObserver<ReservationServiceProto.ReservationsResponse> responseObserver){

        List<Reservation> reservations = reservationService.GetAllReservations();

        ReservationServiceProto.ReservationsResponse.Builder response = ReservationServiceProto.ReservationsResponse.newBuilder();
        ReservationServiceProto.User.Builder user = ReservationServiceProto.User.newBuilder();
        ReservationServiceProto.Chambre.Builder chambre = ReservationServiceProto.Chambre.newBuilder();

        for (Reservation reservation : reservations) {
            if (reservation.getUser().getEmail() == null) {
                user.setNom("null")
                        .setPrenom("null")
                        .setEmail("null")
                        .setTelephone("null")
                        .setAdresse("null")
                        .setCni("null");
            } else {
                user.setNom(reservation.getUser().getNom())
                        .setPrenom(reservation.getUser().getPrenom())
                        .setEmail(reservation.getUser().getEmail())
                        .setTelephone(reservation.getUser().getTelephone())
                        .setAdresse(reservation.getUser().getAdresse())
                        .setCni(reservation.getUser().getCni());
            }
            user.build();

            if (reservation.getChambre().getNumero() == null){
                chambre.setNumero("null")
                        .setNombreLits(0)
                        .setPrix(0)
                        .setImage("null")
                        .setDescription("null")
                        .setDisponible(false);

            } else {
                chambre.setNumero(reservation.getChambre().getNumero())
                        .setNombreLits(reservation.getChambre().getNombre_lits())
                        .setPrix(reservation.getChambre().getPrix())
                        .setImage(reservation.getChambre().getImage())
                        .setDescription(reservation.getChambre().getDescription())
                        .setDisponible(reservation.getChambre().getDisponible());
            }
            chambre.build();

            ReservationServiceProto.ReservationResponse reservationResponse = ReservationServiceProto.ReservationResponse.newBuilder()
                    .setId(reservation.getId())
                    .setUserId(reservation.getUserId())
                    .setChambreId(reservation.getChambreId())
                    .setDateDebut(reservation.getDateDebut())
                    .setDateFin(reservation.getDateFin())
                    .setMontantTotal(reservation.getMontant_total())
                    .setUser(user)
                    .setChambre(chambre)
                    .build();

            response.addReservations(reservationResponse);
        }

        // Send the response back to the client
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();  // Mark the RPC call as completed

    }


}
