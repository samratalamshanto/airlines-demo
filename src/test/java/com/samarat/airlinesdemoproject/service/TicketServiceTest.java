package com.samarat.airlinesdemoproject.service;

import com.samarat.airlinesdemoproject.config.exception.DateParseException;
import com.samarat.airlinesdemoproject.repository.TicketRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TicketServiceTest extends BaseClassTest {
    @Autowired
    TicketRepository ticketRepository;
    TicketService ticketService = new TicketService(ticketRepository);

    @Test
    @DisplayName("Given date empty(''), so it will throw exception.")
    void getTotalSaleOfADate() {
        DateParseException dateParseException = assertThrows(DateParseException.class, () -> {
            ticketService.getTotalSaleOfADate("");
        });
        assertTrue(dateParseException.getMessage().equals("Date Parsing Error. Please give the correct date format('yyyy-MM-dd')"));
    }

    @Test
    @DisplayName("Given date wrong format(02-1-2024), so it will throw exception.")
    void getTotalSaleOfADate2() {
        DateParseException dateParseException = assertThrows(DateParseException.class, () -> {
            ticketService.getTotalSaleOfADate("02-1-2024");
        });
        assertTrue(dateParseException.getMessage().equals("Date Parsing Error. Please give the correct date format('yyyy-MM-dd')"));
    }

    @Test
    @DisplayName("Get the size of tickets")
    void Test() {
        assertEquals(4,ticketRepository.findAll().size());
    }
}