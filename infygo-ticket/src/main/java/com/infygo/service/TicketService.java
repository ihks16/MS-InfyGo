package com.infygo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infygo.dto.FlightDetailsdto;
import com.infygo.dto.PassengerDetailsDto;
import com.infygo.dto.TicketDetailsDto;
import com.infygo.dto.UserDetailsDto;
import com.infygo.entity.PassengerDetails;
import com.infygo.entity.TicketDetails;

import com.infygo.exception.UserNotExist;
import com.infygo.exception.flightNotExist;
import com.infygo.exception.seatNotAvailable;

import com.infygo.repository.passengerRepository;
import com.infygo.repository.ticketRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class TicketService {
	
	Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private ticketRepository ticketRepository;

	
	@Autowired
	private ticketFlightFeign flightFeign;
	
	@Autowired
	private ticketUserFeign userFeign;
	
//	@Autowired
//	private flightRepository flightRepository;
//
//	@Autowired
//	private userRepository userRepository;
	
	@Autowired
	private passengerRepository passengerRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@CircuitBreaker(name = "ticketService",fallbackMethod = "getBookTicketDetailsFallback")
	public TicketDetails bookTicket(String flightId,String userId,List<PassengerDetailsDto> passengerDetailsDtos) throws flightNotExist, UserNotExist, seatNotAvailable {
		
		System.out.println("#######################################");
//		System.out.println("flight id :"+flightId);
//		System.out.println("user id :"+userId);
//		
		
//		flight =  restTemplate.getForObject("http://localhost:9200/flight/flightId/"+flightId, FlightDetailsdto.class);
		//######################################################################################################3
//		List<ServiceInstance> listOfFlightInstances = discoveryClient.getInstances("infygo-flight");
//		System.out.println("below client");
//		String flightUri=null;
//	    if (listOfFlightInstances != null && !listOfFlightInstances.isEmpty() ) {
//	    	System.out.println("inside if");
//	        flightUri=listOfFlightInstances.get(0).getUri().toString();
//	    }
//	    //System.out.println("after if");
//	    //System.out.println(flightUri);
//		flight =  restTemplate.getForObject(flightUri+"/flight/flightId/"+flightId, FlightDetailsdto.class);
		//discovery client
		//##############################################################################################################
		
		
		FlightDetailsdto flight = null;
		//dynamic loadbalacing
		flight =  restTemplate.getForObject("http://infygo-flight/flight/flightId/"+flightId, FlightDetailsdto.class);
		try {
//		flight = flightFeign.getSpecificFlight(flightId);
		}catch(Exception e) {
			throw new flightNotExist("please enter valid flight id flight with given id is not exist in database");
		}
		

	
		
		//System.out.println("flight");
		
//		user = restTemplate.getForObject("http://localhost:9300/user/user/"+userId, UserDetailsDto.class);
		
		//##########################################################################################################
//		List<ServiceInstance> listOfUSerInstance = discoveryClient.getInstances("infygo-user");
//		String userUri= null;
//		if(listOfUSerInstance != null && !listOfUSerInstance.isEmpty()) {
//			System.out.println("inside if of user uri fetdch");
//			userUri=listOfUSerInstance.get(0).getUri().toString();
//		}
//		System.out.println("not fetch user uri");
//		user = restTemplate.getForObject(userUri+"/user/user/"+userId, UserDetailsDto.class );
//		
		//client discovery
		//##################################################################################################################
		
		
		//using dynamic loadbalancing
		UserDetailsDto user = null;
		user = restTemplate.getForObject("http://infygo-user/user/"+userId, UserDetailsDto.class);
		try {
//		user = userFeign.getSpecificFlight(userId);
		}catch(Exception e) {
			throw new UserNotExist("user with given id is not exist please enter valid user id");
		}
		
		System.out.println("user receive");
		
//		FlightDetailsdto flightDetails = flight.get();
//		UserDetailsDto userDetails =user.get();
		int seatRequire= passengerDetailsDtos.size();

		if(flight.getSeatCount()>=seatRequire) {
			TicketDetails ticketDetails = new TicketDetails();
				
				ticketDetails.setBookingDate(new java.util.Date());
				ticketDetails.setDeparturefDate(flight.getFlightAvailableDate());
				ticketDetails.setDepartureTime(flight.getDepartureTime());
				ticketDetails.setFlightId(flight.getFlightId());
				ticketDetails.setNoOfSeats(seatRequire);
				ticketDetails.setTotalFare(((flight.getFare())*seatRequire));
				ticketDetails.setUserId(user.getUserId());
				
				ticketRepository.saveAndFlush(ticketDetails);
				
				for(int i=0;i<passengerDetailsDtos.size();i++) {
					
					PassengerDetails passengerDetails = new PassengerDetails();
					passengerDetails.setPassengerName(passengerDetailsDtos.get(i).getPassengerName());
					System.out.println("name : "+passengerDetailsDtos.get(i).getPassengerName());
					passengerDetails.setPassengerGender(passengerDetailsDtos.get(i).getPassengerGender());
					passengerDetails.setPasssengerAge(passengerDetailsDtos.get(i).getPasssengerAge());
					passengerDetails.setTicketpnr(ticketDetails.getPnr());
					passengerRepository.saveAndFlush(passengerDetails);
//					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
				}
			
			flight.setSeatCount(flight.getSeatCount()-seatRequire);
//			flightRepository.save(flight);
			restTemplate.postForEntity("http://infygo-flight/flight", flight, null);
//			TicketDetailsDto ticketDetailsDto = this.modelMapper.map(ticketDetails, TicketDetailsDto.class);
//			return new ResponseEntity<TicketDetailsDto>(this.modelMapper.map(ticketDetails, TicketDetailsDto.class),HttpStatus.ACCEPTED);
			return ticketDetails;	
			}else
			{
				throw  new seatNotAvailable("number  of  seat availabale is less than requirment");
			}
	}
	// fallbackmethod
	public TicketDetails getBookTicketDetailsFallback(String flightId,String userId,List<PassengerDetailsDto> passengerDetailsDtos,Throwable throwable) {
		logger.info("============ In Fallback of FlightDetails=============");
		return new TicketDetails();
	}
	

}
