package com.example.reservationservicee.controller;

import com.example.reservationservicee.entity.Reservation;

import com.example.reservationservicee.model.Chambre;
import com.example.reservationservicee.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Reservation> reservationList;
    private List<Chambre> chambresDisponibles;

    @BeforeEach
    void setUp() {
        this.reservationList = List.of(
                new Reservation(1L, 1L, 1L, new Date(), new Date(), 1000.0, null, null),
                new Reservation(2L, 2L, 2L, new Date(), new Date(), 800.0, null, null)
        );

        this.chambresDisponibles = List.of(
                new Chambre(1L, "101", 2, 300, "image1.png", "Test 1", true, 3, 2, "double"),
                new Chambre(2L, "102", 3, 400, "image2.png", "Test 2", true, 4, 3, "suite")
        );
    }

    @Test
    void createReservation() throws Exception {
        Reservation newReservation = new Reservation(null, 1L, 1L, new Date(), new Date(), 1200.0, null, null);

        Mockito.when(reservationService.create_reservation(Mockito.any(Reservation.class))).thenReturn(reservationList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/reservations")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(newReservation)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(reservationList.get(0))));
    }

    @Test
    void updateReservation() throws Exception {
        Long id = 1L;
        Reservation updatedReservation = new Reservation(id, 1L, 1L, new Date(), new Date(), 1500.0, null, null);

        Mockito.when(reservationService.update_reservation(Mockito.any(Reservation.class), Mockito.anyLong())).thenReturn(updatedReservation);

        mockMvc.perform(MockMvcRequestBuilders.put("/reservations/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(updatedReservation)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(updatedReservation)));
    }

    @Test
    void deleteReservation() throws Exception {
        Long id = 1L;

        Mockito.doNothing().when(reservationService).delete_reservation(Mockito.anyLong());

        mockMvc.perform(MockMvcRequestBuilders.delete("/reservations/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getReservation() throws Exception {
        Long id = 1L;

        Mockito.when(reservationService.get_reservation(Mockito.anyLong())).thenReturn(reservationList.get(0));

        mockMvc.perform(MockMvcRequestBuilders.get("/reservations/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(reservationList.get(0))));
    }

    @Test
    void getAllReservations() throws Exception {
        Mockito.when(reservationService.getAll_reservation()).thenReturn(reservationList);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(reservationList)));
    }

    /*@Test
    void getChambresDisponibles() throws Exception {
        Mockito.when(reservationService.getChambresDisponibles()).thenReturn(chambresDisponibles);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservations/chambres-disponibles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(chambresDisponibles)));
    }*/
}
