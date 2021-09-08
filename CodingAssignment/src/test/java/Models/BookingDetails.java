package Models;

import java.util.Date;

public class BookingDetails {
	String confirmationID;
	String status;
	Double amount;
	String expiration;
	String authCode;
	Date dateOfBooking;
	String cardNumber;
	
	public BookingDetails() {
		confirmationID="";
		status="";
		amount=0.0;
		expiration="";
		authCode="";
		dateOfBooking=new Date();
		cardNumber="";
	}
	
	public BookingDetails(String confirmationID,String status,Double amount, String expiration, String authCode, Date dateOfBooking, String cardNumber) {
		this.confirmationID=confirmationID;
		this.status=status;
		this.amount=amount;
		this.expiration=expiration;
		this.authCode=authCode;
		this.dateOfBooking=dateOfBooking;
		this.cardNumber=cardNumber;
	}
	
	public String getConfirmationID() {
		return confirmationID;
	}
	public void setConfirmationID(String confirmationID) {
		this.confirmationID=confirmationID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount=amount;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration=expiration;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode=authCode;
	}
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking=dateOfBooking;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber=cardNumber;
	}
}
