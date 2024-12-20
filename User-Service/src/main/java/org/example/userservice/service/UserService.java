package org.example.userservice.service;

import org.example.userservice.entity.User;
import org.example.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create_user(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll_users() {
        return userRepository.findAll();
    }
    public User get_user(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User update_user(User user, Long id) {
        return userRepository.findById(id).map(user1 -> {
            user1.setNom(user.getNom());
            user1.setPrenom(user.getPrenom());
            user1.setEmail(user.getEmail());
            user1.setAdresse(user.getAdresse());
            user1.setTelephone(user.getTelephone());
            user1.setCni(user.getCni());
            user1.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user1);
            }

        ).orElseThrow((() -> new RuntimeException("user not found")));
    }



    public void delete_user(Long id) {
        userRepository.deleteById(id);
    }


    public User get_user_by_email(String email) {

        return userRepository.findByEmail(email);
    }
}
