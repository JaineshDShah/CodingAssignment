package Models;

public class Address {
	private String address;
	private String city;
	private String state;
	private int zipCode;
	
	//Default Constructor
	public Address() {
		address="";
		city="";
		state="";
		zipCode=0;
	}
	
	//Parameterized Constructor
	public Address(String address, String city, String state, int zipCode) {
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipCode=zipCode;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode=zipCode;
	}
}
