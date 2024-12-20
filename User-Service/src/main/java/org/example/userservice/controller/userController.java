package org.example.userservice.controller;

import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Utilisateurs")
public class userController {

    public UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.create_user(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id) {
        return ResponseEntity.ok(userService.update_user(user,id));
    }

     @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete_user(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.get_user(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAll_users());
    }

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
