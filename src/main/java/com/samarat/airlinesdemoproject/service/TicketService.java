package com.samarat.airlinesdemoproject.service;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import com.samarat.airlinesdemoproject.entity.Ticket;
import com.samarat.airlinesdemoproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public CommonResponse getTotalSaleOfADate(String selectedDate) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(selectedDate, pattern);
        double totalSale = 0.0;
        List<Ticket> ticketList = ticketRepository.findAllByFlightDate(date);
        for (Ticket ticket : ticketList) {
            totalSale += ticket.getTicketPrice() + ticket.getFood().getPrice();
        }
        CommonResponse commonResponse = new CommonResponse(200, true, "Successfully get total amount.", totalSale);
        return commonResponse;
    }

    public LocalDate getMaxSaleDateOfAllTime(String selectedDateFrom, String selectedDateTo) {
        return null;
    }
}
