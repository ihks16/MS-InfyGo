package com.infygo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infygo.dto.FlightDetailsdto;
import com.infygo.entity.FlightDetails;

public interface FlightRepository extends JpaRepository<FlightDetails, String>{

	
	public List<FlightDetails> findBySource(String city);
	
	public List<FlightDetails> findByDestination(String city);
	
	public List<FlightDetails> findBySourceAndDestinationAndFlightAvailableDate(String source,String destination,Date date);
}
