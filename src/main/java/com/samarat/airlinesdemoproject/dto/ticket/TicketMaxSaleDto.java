package com.samarat.airlinesdemoproject.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketMaxSaleDto {
    private LocalDate date;
    private double totalSale;
}
