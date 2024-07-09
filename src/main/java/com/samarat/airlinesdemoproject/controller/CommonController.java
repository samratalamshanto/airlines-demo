package com.samarat.airlinesdemoproject.controller;

import com.samarat.airlinesdemoproject.dto.CommonResponse;
import com.samarat.airlinesdemoproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CommonController {
    private final TicketService ticketService;

    @GetMapping("/get-total-sale")
    public CommonResponse getTotalSale(@RequestParam("selectedDate") String selectedDate) {
        return ticketService.getTotalSaleOfADate(selectedDate);
    }

    @GetMapping("/get-max-sale")
    public CommonResponse getMaxSaleDateOfAllTime(@RequestParam("selectedDateFrom") String selectedDateFrom, @RequestParam("selectedDateTo") String selectedDateTo) {
        return ticketService.getMaxSaleDateOfAllTime(selectedDateFrom, selectedDateTo);
    }

    @GetMapping("/get-top-three-route")
    public CommonResponse getTopMaxSaleThreeRoute() {
        return ticketService.getTopMaxSaleThreeRoute();
    }

}
