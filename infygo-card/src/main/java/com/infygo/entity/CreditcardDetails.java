package com.infygo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CreditcardDetails {
	
	@Id
	private String cardNumber;	
	private String apin;	
	private String cardHolderName;
	private String cvv;
	private String expiryMonth;
	private String expiryYear;
	private String totalBill;
	public CreditcardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditcardDetails(String cardNumber, String apin, String cardHolderName, String cvv, String expiryMonth,
			String expiryYear, String totalBill) {
		super();
		this.cardNumber = cardNumber;
		this.apin = apin;
		this.cardHolderName = cardHolderName;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getApin() {
		return apin;
	}
	public void setApin(String apin) {
		this.apin = apin;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	@Override
	public String toString() {
		return "CreditcardDetails [cardNumber=" + cardNumber + ", apin=" + apin + ", cardHolderName=" + cardHolderName
				+ ", cvv=" + cvv + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", totalBill="
				+ totalBill + "]";
	}
	
}
