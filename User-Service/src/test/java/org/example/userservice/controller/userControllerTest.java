package org.example.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apiguardian.api.API;
import org.example.userservice.entity.User;
import org.example.userservice.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(userController.class)
class userControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private List<User> userList;

    @BeforeEach
    void setUp() {
        this.userList = List.of(
                new User(1L,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234"),
                new User(2L,"user2","user2","user2@gmail.com","0666666666","Rue malik","LA789","1234")
        );
    }
    @Test
    void createUser()  throws Exception {
        User user =  new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");
        Mockito.when(userService.create_user(Mockito.any(User.class))).thenReturn(userList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/Utilisteurs")
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userList.get(0))));
    }

    @Test
    void updateUser() throws Exception {
        Long id = 1L;
        User user_modifiy =  new User(null,"user1","user1","user1@gmail.com","0666666666","Rue malik","LA12346","1234");

        Mockito.when(userService.update_user(Mockito.any(User.class),Mockito.anyLong())).thenReturn(user_modifiy);

        mockMvc.perform(MockMvcRequestBuilders.put("/Enseignants/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(user_modifiy)))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(user_modifiy)));


    }
    @Test
    void deleteUser() throws Exception{
        Long id = 1L;
        mockMvc.perform(MockMvcRequestBuilders.delete("/Utilisateurs/{id}",id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getUser() throws Exception {
        Long id=1L;
        Mockito.when(userService.get_user(Mockito.anyLong())).thenReturn(userList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get("/Utilisateurs/{id}",id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userList.get(0))));
    }
    @Test
    void getAllUser() throws Exception {

        Mockito.when(userService.getAll_users()).thenReturn(userList);

        mockMvc.perform(MockMvcRequestBuilders.get("/Utilisateurs"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(userList)));


    }

    @Test
    void getUserByEmail() throws Exception{
        String email="user1@mail.com";
        Mockito.when(userService.get_user_by_email(Mockito.anyString())).thenReturn(userList.get(0));

        Map<String, String> infos_user = new HashMap<>();
        infos_user.put("email", userList.get(0).getEmail());
        infos_user.put("password", userList.get(0).getPassword());

        mockMvc.perform(MockMvcRequestBuilders.get("/Utilisateurs/email/{email}",email))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(infos_user)));
    }
}