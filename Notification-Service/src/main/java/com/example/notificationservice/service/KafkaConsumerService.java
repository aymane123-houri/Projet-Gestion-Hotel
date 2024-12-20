package com.example.notificationservice.service;

import com.example.notificationservice.document.Notification;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final EmailService emailService;

    public KafkaConsumerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "notification-email_topic", groupId = "hotelier-group")
    public void consumeConfirmationEmailNotification(Notification notification) throws MessagingException {
        emailService.sendConfirmationEmail(notification);
    }



}