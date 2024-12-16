package com.example.reservationservicee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceeApplication.class, args);
    }

}
