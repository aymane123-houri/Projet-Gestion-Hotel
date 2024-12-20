package com.example.notificationservice.service;

import com.example.notificationservice.document.Notification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Notification> kafkaTemplate1;


    public KafkaProducerService(KafkaTemplate<String, Notification> kafkaTemplate1) {
        this.kafkaTemplate1 = kafkaTemplate1;

    }

    public void sendConfirmationEmail(Notification notification) {
        kafkaTemplate1.send("notification-email_topic", notification);
    }



}
