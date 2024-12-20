package org.example.userservice.service;

import org.assertj.core.api.AssertionsForClassTypes;
import org.example.userservice.entity.User;
import org.example.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    void create_user() {
        User user = new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        User Usersaved = new User(1L,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        // action
        Mockito.when(userRepository.save(user)).thenReturn(Usersaved);
        // tester
        User resultat = userService.create_user(user);
        // vérifier
        AssertionsForClassTypes.assertThat(resultat).usingRecursiveComparison().isEqualTo(Usersaved);
    }

    @Test
    void getAll_users() {
        List<User> usertList = List.of(
                new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234"),
                new User(null,"user2","user2","user2@gmail.com","0666666666","Rue malik","LA789","1234")
        );
        // action
        Mockito.when(userRepository.findAll()).thenReturn(usertList);
        List<User> result = userService.getAll_users();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(usertList);
    }

    @Test
    void get_user() {
        Long id = 1L;
        User user = new User(1L,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        User result = userService.get_user(id);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(user);
    }

    @Test
    void update_user() {
        Long id = 1L;
        User user = new User(1L,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        User user_modify = new User(1L,"user11","user11","user11@gmail.com","0666666666","Rue malik","LA12346","1234");

        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(user)).thenReturn(user_modify);

        User result = userService.update_user(user_modify, id);

        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(user_modify);
    }

    @Test
    void delete_user() {
        Long id = 1L;
        userService.delete_user(id);
    }

    @Test
    void get_user_by_email() {
        String email = "user1@mail.com";
        User user = new User(1L,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        Mockito.when(userRepository.findByEmail(email)).thenReturn(user);
        User result = userService.get_user_by_email(email);
        AssertionsForClassTypes.assertThat(result).isNotNull();
        AssertionsForClassTypes.assertThat(result).usingRecursiveComparison().isEqualTo(user);
    }

}