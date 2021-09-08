package Models;

public class PassengerDetails {
	private String firstName;
	private String lastName;
	
	public PassengerDetails(){
		this.firstName="";
		this.lastName="";
	}
	
	public PassengerDetails(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
}
