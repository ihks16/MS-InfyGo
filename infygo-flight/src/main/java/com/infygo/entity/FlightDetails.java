package com.infygo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class FlightDetails {
	
	@Id
	private String flightId;
	private String airline;
	private String arrivalTime;
	private String departureTime;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date flightAvailableDate;
	private Double fare;
	private int seatCount;
	private String source;
	
//	@OneToMany (mappedBy = "flightId",cascade = CascadeType.ALL)
//	private List<TicketDetails> ticketDetails;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightAvailableDate() {
		return flightAvailableDate;
	}

	public void setFlightAvailableDate(Date flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

//	public List<TicketDetails> getTicketDetails() {
//		return ticketDetails;
//	}
//
//	public void setTicketDetails(List<TicketDetails> ticketDetails) {
//		this.ticketDetails = ticketDetails;
//	}

	
	
}
