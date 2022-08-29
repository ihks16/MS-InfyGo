package com.infygo.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.dto.PassengerDetailsDto;
import com.infygo.dto.TicketDetailsDto;
import com.infygo.entity.TicketDetails;
import com.infygo.exception.UserNotExist;
import com.infygo.exception.FlightNotExist;
import com.infygo.exception.SeatNotAvailable;
import com.infygo.service.TicketService;

@RestController
@RequestMapping("/ticket")
@Validated
public class TicketController {

	@Autowired
	private ticketService ticketService;
	
	@PostMapping("/book/flightId/{flightId}/userId/{userId}")
	public ResponseEntity<TicketDetails> bookTicked(@PathVariable("flightId") @NotNull(message = "enter flight Id") String flightId,
			@PathVariable("userId") @NotNull (message = "enter user id") String userId,
			@RequestBody List<PassengerDetailsDto> passengerDetailsDto
			) throws flightNotExist, UserNotExist, seatNotAvailable{
		
		return new ResponseEntity<TicketDetails>(ticketService.bookTicket(flightId, userId, passengerDetailsDto),HttpStatus.ACCEPTED);
	}
}
