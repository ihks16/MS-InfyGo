package com.infygo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infygo.dto.FlightDetailsdto;
import com.infygo.entity.FlightDetails;
import com.infygo.exception.FlightNotExist;
import com.infygo.service.FlightService;

@RestController
@RequestMapping("/flight")
@Validated
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@PostMapping
	public ResponseEntity<String> addFlight(@Valid @RequestBody FlightDetailsdto flightDetailsdto){
		flightService.addFlight(flightDetailsdto);
		return new ResponseEntity<String>("Flight added successfully", HttpStatus.ACCEPTED);
	}
	
	@GetMapping
	public List<FlightDetailsdto> getAllflights(){
		return flightService.getAllFlights();
	}
	
	@GetMapping("/source/city/{city}")
	public List<FlightDetailsdto> findBySource(@PathVariable("city") String city){
		return flightService.findBYSource(city);
	}
	

	@GetMapping("/destination/city/{city}")
	public List<FlightDetailsdto> findByDestination(@PathVariable("city") String city){
		return flightService.findBYDestination(city);
	}
	@GetMapping("/search/source/{source}/destination/{destination}/date/{journeydate}")
	public List<FlightDetailsdto> searchFlight( @PathVariable("source") @NotNull(message = "source can not empty")String source,
												@PathVariable("destination")@NotNull(message = "destination can not empty") String destination ,
												@PathVariable("journeydate")	
													@FutureOrPresent(message = "please ennter Future Date") Date date){
		System.out.println(" "+source +" " +destination+ " "+ date);
		List<FlightDetailsdto> flightDetailsdtos = flightService.serachFlight(source, destination, date);
		
		return flightDetailsdtos;
	}
	
	@GetMapping("/flightId/{flightId}")
	public FlightDetailsdto findByflightId(@PathVariable("flightId") String flightId) throws flightNotExist{
		return flightService.findbyId(flightId);
	}
	
}
