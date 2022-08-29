package com.infygo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

public class FlightDetailsdto {

	private String flightId;
	
	@NotNull
	private String airline;
	
	@NotNull
	private String arrivalTime;
	
	@NotNull
	private String departureTime;
	
	@NotNull
	private String destination;
	
	@NotNull
	private Date flightAvailableDate;
	
	@NotNull
	private Double fare;
	
	@NotNull
	private int seatCount;
	
	@NotNull
	private String source;
	
	public FlightDetailsdto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlightDetailsdto(String flightId, String airline, String arrivalTime, String departureTime,
			String destination, Date flightAvailableDate, Double fare, int seatCount, String source) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.destination = destination;
		this.flightAvailableDate = flightAvailableDate;
		this.fare = fare;
		this.seatCount = seatCount;
		this.source = source;
//		this.ticketDetailsDtos = ticketDetailsDtos;
	}
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
	@Override
	public String toString() {
		return "FlightDetailsdto [flightId=" + flightId + ", airline=" + airline + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", destination=" + destination + ", flightAvailableDate="
				+ flightAvailableDate + ", fare=" + fare + ", seatCount=" + seatCount + ", source=" + source
				+ ", ticketDetailsDtos=" + "]";
	}

	
	
}
