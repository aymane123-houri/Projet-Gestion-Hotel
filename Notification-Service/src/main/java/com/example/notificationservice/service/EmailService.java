package com.example.notificationservice.service;

import com.example.notificationservice.document.Notification;
import com.example.notificationservice.model.Messages;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendConfirmationEmail(Notification notification) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(notification.getReservation().getUser().getEmail());

        helper.setSubject("Confirmation de Reservation de votre chambre");

        helper.setText( new Messages().getConfirmationMessage(notification.getReservation(), notification.getReservation().getUser(), notification.getReservation().getChambre()));

        mailSender.send(message);
    }


}
