package com.samarat.airlinesdemoproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ticket_details")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double ticketPrice;
    @OneToOne
    private Route route;
    @OneToOne
    private Food food;
    private LocalDate flightDate;
}
