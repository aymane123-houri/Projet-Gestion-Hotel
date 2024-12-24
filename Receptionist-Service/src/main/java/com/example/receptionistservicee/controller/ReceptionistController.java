package com.example.receptionistservicee.controller;

import com.example.receptionistservicee.entity.Receptionist;
import com.example.receptionistservicee.service.ReceptionistService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des Receptioniste",
                description = " Gerer les opération de banque",
                version = "1.0.0"
        ),

        servers = @Server(
                url = "http://receptionist-service:8085/"
        )
)

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Administrator")
public class ReceptionistController {

    public ReceptionistService receptionistService;

    public ReceptionistController(ReceptionistService receptionistService) {
        this.receptionistService = receptionistService;
    }


    @Operation(
            summary = "Créer un nouveau réceptionniste",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Receptionist.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réceptionniste créé avec succès", content = @Content(schema = @Schema(implementation = Receptionist.class))),
                    @ApiResponse(responseCode = "400", description = "Données invalides fournies"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @PostMapping
    public ResponseEntity<Receptionist> createUser(@RequestBody Receptionist receptionist) {
        return ResponseEntity.ok(receptionistService.create_Receptionist(receptionist));
    }

    @Operation(
            summary = "Mettre à jour un réceptionniste",
            parameters = @Parameter(name = "id", description = "ID du réceptionniste à mettre à jour", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réceptionniste mis à jour avec succès", content = @Content(schema = @Schema(implementation = Receptionist.class))),
                    @ApiResponse(responseCode = "404", description = "Réceptionniste non trouvé"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Receptionist> updateReceptionist(@RequestBody Receptionist receptionist,@PathVariable String id) {
        return ResponseEntity.ok(receptionistService.update_receptionist(receptionist,id));
    }

    @Operation(
            summary = "Supprimer un réceptionniste",
            parameters = @Parameter(name = "id", description = "ID du réceptionniste à supprimer", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réceptionniste supprimé avec succès"),
                    @ApiResponse(responseCode = "404", description = "Réceptionniste non trouvé"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
     @DeleteMapping("/{id}")
    public void deleteReceptionist(@PathVariable String id) {
        receptionistService.delete_receptionist(id);
    }


    @Operation(
            summary = "Récupérer un réceptionniste par ID",
            parameters = @Parameter(name = "id", description = "ID du réceptionniste à récupérer", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réceptionniste trouvé avec succès", content = @Content(schema = @Schema(implementation = Receptionist.class))),
                    @ApiResponse(responseCode = "404", description = "Réceptionniste non trouvé"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Receptionist> getReceptionist(@PathVariable String id) {
        return ResponseEntity.ok(receptionistService.get_receptionist(id));
    }

    @Operation(
            summary = "Récupérer la liste de tous les réceptionnistes",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste récupérée avec succès", content = @Content(schema = @Schema(implementation = Receptionist.class))),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping
    public ResponseEntity<List<Receptionist>> getAllReceptionist() {
        return ResponseEntity.ok(receptionistService.getAll_receptionist());
    }

    @Operation(
            summary = "Récupérer un réceptionniste par email",
            parameters = @Parameter(name = "email", description = "Email du réceptionniste", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Réceptionniste trouvé avec succès", content = @Content(schema = @Schema(implementation = Receptionist.class))),
                    @ApiResponse(responseCode = "404", description = "Réceptionniste non trouvé"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Receptionist> getUserByEmail(@PathVariable String email) {

        Receptionist receptionist = receptionistService.get_receptionist_by_email(email);
            return ResponseEntity.ok(receptionist);

    }

}
