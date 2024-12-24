package com.example.reservationservicee.controller;

import com.example.reservationservicee.entity.Reservation;
import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.service.ReservationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des Reservations",
                description = " Gerer les opération de banque",
                version = "1.0.0"
        ),

        servers = @Server(
                url = "http://reservation-service:8087/"
        )
)

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Reservations")
public class ReservationController {


    public ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    @Operation(
            summary = "Créer une réservation",
            description = "Permet de créer une nouvelle réservation",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Les détails de la réservation à créer",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reservation.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réservation créée avec succès", content = @Content(schema = @Schema(implementation = Reservation.class))),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        logger.info("Données reçues pour la réservation : {}", reservation);
        return ResponseEntity.ok(reservationService.create_reservation(reservation));
    }


    @Operation(
            summary = "Mettre à jour une réservation",
            description = "Met à jour une réservation existante par son ID",
            parameters = {
                    @Parameter(name = "id", description = "ID de la réservation à mettre à jour", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réservation mise à jour avec succès", content = @Content(schema = @Schema(implementation = Reservation.class))),
                    @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation,@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.update_reservation(reservation,id));
    }

    @Operation(
            summary = "Supprimer une réservation",
            description = "Supprime une réservation par son ID",
            parameters = {
                    @Parameter(name = "id", description = "ID de la réservation à supprimer", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réservation supprimée avec succès"),
                    @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.delete_reservation(id);
    }

    @Operation(
            summary = "Obtenir une réservation par ID",
            description = "Récupère les détails d'une réservation en utilisant son ID",
            parameters = {
                    @Parameter(name = "id", description = "ID de la réservation à récupérer", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réservation récupérée avec succès", content = @Content(schema = @Schema(implementation = Reservation.class))),
                    @ApiResponse(responseCode = "404", description = "Réservation non trouvée"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.get_reservation(id));
    }

    @Operation(
            summary = "Obtenir toutes les réservations",
            description = "Récupère la liste de toutes les réservations",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des réservations récupérée avec succès", content = @Content(schema = @Schema(implementation = Reservation.class))),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservation() {
        return ResponseEntity.ok(reservationService.getAll_reservation());
    }

    @Operation(
            summary = "Obtenir les chambres disponibles",
            description = "Récupère les chambres disponibles pour une période donnée et en fonction des occupants",
            parameters = {
                    @Parameter(name = "dateDebut", description = "Date de début du séjour", required = true),
                    @Parameter(name = "dateFin", description = "Date de fin du séjour", required = true),
                    @Parameter(name = "nombreAdulte", description = "Nombre d'adultes", required = true),
                    @Parameter(name = "nombreEnfant", description = "Nombre d'enfants", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des chambres disponibles récupérée avec succès", content = @Content(schema = @Schema(implementation = Chambre.class))),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping("/chambres-disponibles")
    public ResponseEntity<List<Chambre>> getChambresDisponibles(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateDebut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin,
            @RequestParam int nombreAdulte,
            @RequestParam int nombreEnfant
    ) {
        try {
            List<Chambre> chambresDisponibles = reservationService.getChambresDisponibles(dateDebut,dateFin,nombreAdulte,nombreEnfant);
            return ResponseEntity.ok(chambresDisponibles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}