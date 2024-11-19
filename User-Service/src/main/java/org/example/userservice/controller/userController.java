package org.example.userservice.controller;

import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Utilisateurs")
public class userController {

    public UserService userService;

    public userController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.create_user(user);
        return ResponseEntity.ok(user1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long id) {
        User user1 = userService.update_user(user,id);
        return ResponseEntity.ok(user1);
    }

     @DeleteMapping("/{id}")
    public void deleteUser(Long id) {
        userService.delete_user(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(Long id) {
        User user1 = userService.get_user(id);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAll_users();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Map<String,String>> getUserByEmail(String email) {
        User user= userService.get_user_by_email(email);
        if(user!=null){
            Map<String,String> info_User = new HashMap<>();
            info_User.put("email",user.getEmail());
            info_User.put("password",user.getPassword());
            info_User.put("scope",user.getRole());
            return ResponseEntity.ok(info_User);
        }
        return ResponseEntity.notFound().build();

    }

}
