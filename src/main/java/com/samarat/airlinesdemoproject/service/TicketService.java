package com.samarat.airlinesdemoproject.service;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import com.samarat.airlinesdemoproject.dto.ticket.TicketMaxSaleDto;
import com.samarat.airlinesdemoproject.entity.Ticket;
import com.samarat.airlinesdemoproject.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public CommonResponse getTotalSaleOfADate(String selectedDate) {
        LocalDate date = LocalDate.parse(selectedDate, pattern);
        double totalSale = 0.0;
        List<Ticket> ticketList = ticketRepository.findAllByFlightDate(date);
        for (Ticket ticket : ticketList) {
            totalSale += ticket.getTicketPrice() + ticket.getFood().getPrice();
        }
        CommonResponse commonResponse = new CommonResponse(200, true, "Successfully get total amount.", totalSale);
        return commonResponse;
    }

    public CommonResponse getMaxSaleDateOfAllTime(String selectedDateFrom, String selectedDateTo) {
        LocalDate startDate1 = LocalDate.parse(selectedDateFrom, pattern);
        LocalDate endDate1 = LocalDate.parse(selectedDateTo, pattern);
        List<TicketMaxSaleDto> dtoList = ticketRepository.getMaxSaleDateOfAllTime(startDate1, endDate1);
        CommonResponse commonResponse = new CommonResponse(200, true, "Successfully get max sale date.", null);
        if (dtoList.size() == 0) {
            commonResponse.setMessage("No data found between this time range.");
        } else {
            double maxSale = dtoList.getFirst().getTotalSale();
            List<TicketMaxSaleDto> finalList = new ArrayList<>();
            for (TicketMaxSaleDto dto : dtoList) {
                if (dto.getTotalSale() == maxSale) {
                    finalList.add(dto);
                }
            }
            commonResponse.setData(finalList);
            dtoList.clear();
        }
        return commonResponse;
    }
}
