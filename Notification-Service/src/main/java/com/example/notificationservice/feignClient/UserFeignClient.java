package com.example.notificationservice.feignClient;

import com.example.notificationservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "User-Service", url = "http://localhost:8081")
public interface UserFeignClient {
    @GetMapping("/Utilisateurs")
    List<User> getAllUsers();
    @GetMapping("/Utilisateurs/{id}")
    User getUserById(@PathVariable Long id);

}
