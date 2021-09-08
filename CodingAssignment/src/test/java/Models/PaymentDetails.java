package Models;

public class PaymentDetails {
	//enum cardCategory{visa,amex,dinersclub};
	private String cardType;
	private long cardNumber;
	private int month;
	private int year;
	private String nameOnCard;
	
	public PaymentDetails() {
		cardType="";
		cardNumber=0;
		month=0;
		year=0;
		nameOnCard="";
	}
	
	public PaymentDetails(String cardType,long cardNumber,int month, int year, String nameOnCard) {
		
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.month=month;
		this.year=year;
		this.nameOnCard=nameOnCard;
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType=cardType;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber=cardNumber;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month=month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year=year;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard=nameOnCard;
	}
	
}
