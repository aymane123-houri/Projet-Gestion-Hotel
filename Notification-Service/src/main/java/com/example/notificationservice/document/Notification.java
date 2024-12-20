package com.example.notificationservice.document;

import com.example.notificationservice.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notification")
public class Notification {
    private String _id;
    private Date date;
    private Reservation reservation;

    public Notification(Date date, Reservation reservation) {
        this.date = date;
        this.reservation = reservation;
    }
}
