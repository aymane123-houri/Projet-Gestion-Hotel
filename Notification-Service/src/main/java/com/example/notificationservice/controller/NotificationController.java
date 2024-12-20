package com.example.notificationservice.controller;

import com.example.notificationservice.document.Notification;
import com.example.notificationservice.feignClient.ReservationFeignClient;
import com.example.notificationservice.model.*;
import com.example.notificationservice.service.KafkaProducerService;
import com.example.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/Notification")
public class NotificationController {

    private final NotificationService service;
    private final KafkaProducerService kafkaProducerService;
    private final ReservationFeignClient reservationFeignClient;

    public NotificationController(NotificationService service, KafkaProducerService kafkaProducerService, ReservationFeignClient empruntFeignClient) {
        this.service = service;
        this.kafkaProducerService = kafkaProducerService;
        this.reservationFeignClient = empruntFeignClient;
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return service.createNotification(notification);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@PathVariable String id , @RequestBody Notification notification){
        notification.set_id(id);
        return service.updateNotification(notification);
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable String id){
        service.deleteNotification(id);
    }

    @GetMapping("/{id}")
    public Notification getById(@PathVariable String id){
        return service.getById(id);
    }

    @GetMapping
    public List<Notification> getAll(){
        return service.getAll();
    }

    @PostMapping("/send-email/{reservationId}")
    public ResponseEntity<String> sendEmailNotification(@PathVariable Long reservationId) {
        Reservation reservation = reservationFeignClient.getReservationById(reservationId);
        try {
            Notification notification = new Notification(new Date(), reservation);

            kafkaProducerService.sendConfirmationEmail(notification);
            service.createNotification(notification);

            return ResponseEntity.ok("Notification envoyée avec succès !");
        }
        catch (Exception e){
            return ResponseEntity.ok("Error caused by: "+e.getMessage());
        }
    }

}
