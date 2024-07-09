package com.samarat.airlinesdemoproject.repository;


import com.samarat.airlinesdemoproject.dto.ticket.TicketMaxSaleDto;
import com.samarat.airlinesdemoproject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByFlightDate(LocalDate flightDate);


    @Query(value = "SELECT new com.samarat.airlinesdemoproject.dto.ticket.TicketMaxSaleDto(t.flightDate, sum(t.ticketPrice)) " +
            "FROM ticket_details as t " +
            "where t.flightDate between :startDate and :endDate " +
            "group by t.flightDate " +
            "order by sum(t.ticketPrice) desc " )
    List<TicketMaxSaleDto> getMaxSaleDateOfAllTime(LocalDate startDate, LocalDate endDate);

}
