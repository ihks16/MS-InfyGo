package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.entity.TicketDetails;

public interface TicketRepository extends JpaRepository<TicketDetails, Integer>{

}
