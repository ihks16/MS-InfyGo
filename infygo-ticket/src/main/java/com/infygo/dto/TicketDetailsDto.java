package com.infygo.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


import com.infygo.entity.PassengerDetails;


public class TicketDetailsDto {
	
	@NotNull
	private int pnr;
	@NotNull
	private Date bookingDate;
	@NotNull
	private Date departurefDate;
	@NotNull
	private String departureTime;
	
//	private FlightDetailsdto flightId;
	private String flightId;
	
	@NotNull
	private int noOfSeats;
	@NotNull
	private Double totalFare;
	
//	private UserDetailsDto userId;
	private String userId;
	
	private List<PassengerDetails> passengerDetails;

	public TicketDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDetailsDto(int pnr, Date bookingDate, Date departurefDate, String departureTime, String flightId,
			int noOfSeats, Double totalFare, String userId, List<PassengerDetails> passengerDetails) {
		super();
		this.pnr = pnr;
		this.bookingDate = bookingDate;
		this.departurefDate = departurefDate;
		this.departureTime = departureTime;
		this.flightId = flightId;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.userId = userId;
		this.passengerDetails = passengerDetails;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getDeparturefDate() {
		return departurefDate;
	}

	public void setDeparturefDate(Date departurefDate) {
		this.departurefDate = departurefDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	@Override
	public String toString() {
		return "TicketDetailsDto [pnr=" + pnr + ", bookingDate=" + bookingDate + ", departurefDate=" + departurefDate
				+ ", departureTime=" + departureTime + ", flightId=" + flightId + ", noOfSeats=" + noOfSeats
				+ ", totalFare=" + totalFare + ", userId=" + userId + ", passengerDetails=" + passengerDetails + "]";
	}

	
	
}
