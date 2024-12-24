package org.example.userservice.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des Utilisateurs",
                description = " Gerer les Utilisateurs",
                version = "1.0.0"
        ),

        servers = @Server(
                url = "http://user-service:8081/"
        )
)
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Utilisateurs")
public class userController {

    public UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }



    @Operation(
            summary = "Ajouter Un User",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "Application/json",
                            schema = @Schema(implementation = User.class)
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "ajouter par succéses",
                            content = @Content(
                                    mediaType = "Application/json",
                                    schema = @Schema(implementation = User.class))
                    ),

                    @ApiResponse(responseCode = "400",description = "erreur données"),
                    @ApiResponse(responseCode ="500", description = "erreur server")
            }
    )
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.create_user(user));
    }


    @Operation(
            summary = "Mettre à jour un utilisateur par ID",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class)
                    )
            ),
            parameters = @Parameter(
                    name = "id",
                    description = "ID de l'utilisateur à mettre à jour",
                    required = true
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Utilisateur mis à jour avec succès",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Utilisateur introuvable"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id) {
        return ResponseEntity.ok(userService.update_user(user,id));
    }



    @Operation(
            summary = "Supprimer un utilisateur par ID",
            parameters = @Parameter(
                    name = "id",
                    description = "ID de l'utilisateur à supprimer",
                    required = true
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Utilisateur supprimé avec succès"),
                    @ApiResponse(responseCode = "404", description = "Utilisateur introuvable"),
                    @ApiResponse(responseCode = "500", description = "Erreur serveur")
            }
    )
     @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete_user(id);
    }


    @Operation(
            summary = "recuperer un Utilisateur par son Id",
            parameters = @Parameter(
                    name = "id",
                    required = true
            ),
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "bien recuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))
                    ),
                    @ApiResponse(responseCode = "404",description = "user pas trouvé ")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.get_user(id));
    }



    @Operation(
            summary="Recuprer Liste des Utilisateurs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Succès",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(responseCode = "400", description = "Paramètre d'entrée non valide")
            }  )
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAll_users());
    }


    @Operation(
            summary = "Récupérer un utilisateur par email",
            parameters = @Parameter(
                    name = "email",
                    description = "Email de l'utilisateur",
                    required = true
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Utilisateur récupéré avec succès",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Map.class) // Car on retourne un Map<String, String>
                            )
                    ),
                    @ApiResponse(responseCode = "404", description = "Utilisateur introuvable")
            }
    )
    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String,String>> getUserByEmail(@PathVariable String email) {
        /*User user = userService.get_user_by_email(email);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();*/

        User user = userService.get_user_by_email(email);
        if (user!=null) {
            Map<String, String> infos_user = new HashMap<>();

            infos_user.put("email", user.getEmail());
            infos_user.put("password", user.getPassword());
            return ResponseEntity.ok(infos_user);
        }
        return ResponseEntity.notFound().build();

    }

}
