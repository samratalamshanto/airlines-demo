package com.samarat.airlinesdemoproject.entity;

import com.samarat.airlinesdemoproject.dto.ticket.TicketMaxSaleDto;
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
    private Long id;
    private double ticketPrice;
    @ManyToOne
    private Route route;
    @ManyToOne
    private Food food;
    private LocalDate flightDate;
}
