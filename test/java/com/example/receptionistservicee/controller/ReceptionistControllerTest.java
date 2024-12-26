package com.example.receptionistservicee.controller;

import com.example.receptionistservicee.entity.Receptionist;
import com.example.receptionistservicee.service.ReceptionistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mockito.Mock;

@WebMvcTest(ReceptionistController.class)
class ReceptionistControllerTest {

    @Mock
    private ReceptionistService receptionistService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Receptionist> receptionistList;

    @BeforeEach
    void setUp() {
        this.receptionistList = List.of(
                new Receptionist("1L", "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234", "Admin"),
                new Receptionist("2L", "user2", "user2", "user2@gmail.com", "1234", "0666666", "Rue malik", "L5678", "Receptionist")
        );
    }

    @Test
    void createUser() throws Exception {
        Receptionist receptionist = new Receptionist(null, "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234", "Admin");
        Mockito.when(receptionistService.create_Receptionist(Mockito.any(Receptionist.class))).thenReturn(receptionistList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/Administrator")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(receptionist)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(receptionistList.get(0))));
    }

    @Test
    void updateReceptionist() throws Exception {
        String id = "1L";
        Receptionist receptionist_modifiy = new Receptionist("1L", "user1", "user1", "user1@gmail.com", "1234", "0666666", "Rue malik", "L1234", "Admin");

        Mockito.when(receptionistService.update_receptionist(Mockito.any(Receptionist.class), Mockito.anyString())).thenReturn(receptionist_modifiy);

        mockMvc.perform(MockMvcRequestBuilders.put("/Administrator/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(receptionist_modifiy)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(receptionist_modifiy)));
    }

    @Test
    void deleteReceptionist() throws Exception {
        String id = "1L"; // Utilisation du type String comme dans l'entité Receptionist
        mockMvc.perform(MockMvcRequestBuilders.delete("/Administrator/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getReceptionist() throws Exception {
        String id = "1L"; // Utilisation du type String comme dans l'entité Receptionist
        Mockito.when(receptionistService.get_receptionist(Mockito.anyString())).thenReturn(receptionistList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get("/Administrator/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(receptionistList.get(0))));
    }

    @Test
    void getAllReceptionist() throws Exception {
        Mockito.when(receptionistService.getAll_receptionist()).thenReturn(receptionistList);

        mockMvc.perform(MockMvcRequestBuilders.get("/Administrator"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(receptionistList)));
    }

    @Test
    void getUserByEmail() throws Exception {
        String email = "user1@gmail.com"; // Corriger l'email
        Mockito.when(receptionistService.get_receptionist_by_email(Mockito.anyString())).thenReturn(receptionistList.get(0));

        Map<String, String> infos_user = new HashMap<>();
        infos_user.put("email", receptionistList.get(0).getEmail());
        infos_user.put("password", receptionistList.get(0).getPassword());
        infos_user.put("scope", receptionistList.get(0).getRole());

        mockMvc.perform(MockMvcRequestBuilders.get("/Administrator/email/{email}", email))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(infos_user)));
    }
}
