package com.infygo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infygo.dto.FlightDetailsdto;

@FeignClient(name="infygo-flight",url = "http://localhost:9000/")
public interface TicketFlightFeign {

	@RequestMapping("/flight/flightId/{flightId}")
	FlightDetailsdto getSpecificFlight(@PathVariable ("flightId") String flightId);
}
