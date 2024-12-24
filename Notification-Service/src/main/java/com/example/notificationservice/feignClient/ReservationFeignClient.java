package com.example.notificationservice.feignClient;

import com.example.notificationservice.model.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
//@FeignClient(name = "Reservation-Servicee" , url = "http://localhost:8087")
@FeignClient(name = "Reservation-Servicee" , url = "http://reservation-service:8087")
public interface ReservationFeignClient {
    @GetMapping("/Reservations")
    List<Reservation> getAllReservation();
    @GetMapping("/Reservations/{id}")
    Reservation getReservationById(@PathVariable Long id);
}
