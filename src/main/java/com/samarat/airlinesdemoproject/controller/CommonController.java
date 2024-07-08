package com.samarat.airlinesdemoproject.controller;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import com.samarat.airlinesdemoproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommonController {
    private final TicketService ticketService;

    @GetMapping("/get-total-sale")
    public CommonResponse getTotalSale(@RequestParam("selectedDate") String selectedDate) {
        return ticketService.getTotalSaleOfADate(selectedDate);
    }
}
