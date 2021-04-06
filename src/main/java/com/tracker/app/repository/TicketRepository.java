package com.tracker.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.app.model.Ticket;

@Repository("ticketRepository")
public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
