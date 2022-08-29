package com.infygo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.aspectj.apache.bcel.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infygo.dto.FlightDetailsdto;
import com.infygo.entity.FlightDetails;
import com.infygo.exception.flightNotExist;
import com.infygo.repository.flightRepository;


@Service
public class FlightService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private flightRepository flightRepository;
	
	
	//funtion to add flight
	public void addFlight(FlightDetailsdto flightDetailsdto) {
		FlightDetails flightDetails = this.modelMapper.map(flightDetailsdto, FlightDetails.class);
		flightRepository.saveAndFlush(flightDetails);
		
	}
	
	//find all flights
	public List<FlightDetailsdto> getAllFlights(){
		List<FlightDetailsdto> flightDetailsdtos = new ArrayList<>();
		List<FlightDetails> flightDetails = flightRepository.findAll();
		for(FlightDetails f: flightDetails) {
		flightDetailsdtos.add(this.modelMapper.map(f, FlightDetailsdto.class));
		}
		return flightDetailsdtos;
	}
	
	//flights by source city
	public List<FlightDetailsdto> findBYSource(String city){
		List<FlightDetails> flightDetails = flightRepository.findBySource(city);
		List<FlightDetailsdto> flightDetailsdtos = new ArrayList<>();
		for(FlightDetails f : flightDetails) {
			flightDetailsdtos.add(this.modelMapper.map(f, FlightDetailsdto.class));
		}
		return flightDetailsdtos;
	}
	
	// flights by destination
	public List<FlightDetailsdto> findBYDestination(String city){
		List<FlightDetails> flightDetails = flightRepository.findByDestination(city);
		List<FlightDetailsdto> flightDetailsdtos = new ArrayList<>();
		for(FlightDetails f : flightDetails) {
			flightDetailsdtos.add(this.modelMapper.map(f, FlightDetailsdto.class));
		}
		return flightDetailsdtos;
	}
	
	
	public List<FlightDetailsdto> serachFlight(String source,String destination,Date date){
		List<FlightDetailsdto> flightDetailsdtos = new ArrayList<>();
		List<FlightDetails> flDetails = flightRepository.findBySourceAndDestinationAndFlightAvailableDate(source, destination, date);
		
		for(FlightDetails f:flDetails) {
			flightDetailsdtos.add(this.modelMapper.map(f, FlightDetailsdto.class));
		}
		return flightDetailsdtos;
	}
	
	public FlightDetailsdto findbyId(String id) throws flightNotExist {
		Optional<FlightDetails> optional = flightRepository.findById(id);
		if(optional.isPresent()) {
		return this.modelMapper.map(flightRepository.findById(id),FlightDetailsdto.class);
		}
		else {
			throw new flightNotExist("flight with given id is not exist");
		}
	}
	
	

}
