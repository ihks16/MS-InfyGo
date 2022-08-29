package com.infygo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TicketDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pnr;
	@Temporal(TemporalType.DATE)
	
	private Date bookingDate;
	@Temporal(TemporalType.DATE)
	private Date departurefDate;
	private String departureTime;
	
//	@JsonIgnore
//	@ManyToOne(targetEntity = FlightDetails.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "flight_id")
//	private FlightDetails flightId;
//	
	private String flightId;
	
	private int noOfSeats;
	private Double totalFare;
	
//	@JsonIgnore
//	@ManyToOne(targetEntity = UserDetails.class,cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	private UserDetails userId;
	
	private String userId;
	
//	@OneToMany(mappedBy = "ticketpnr")
//	private List<PassengerDetails> passengerDetails;

	
	
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
	
	
}
