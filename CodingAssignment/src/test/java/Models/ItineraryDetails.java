package Models;

public class ItineraryDetails extends JourneyDetails {
	private String flightNo;
	private String airline;
	private JourneyDetails journeyDetail;
	private String startTime;
	private String arrivalTime;
	private String price;
	
	//Default constructor
	public ItineraryDetails() {
		this.flightNo="";
		this.airline="";
		this.journeyDetail = new JourneyDetails();
		this.startTime="";
		this.arrivalTime="";
		this.price="";
	}
	
	//Parameterized Constructor
	public ItineraryDetails(String flightNo, String airline, JourneyDetails journeyDetail, String startTime, String arrivalTime, String price) {
		this.flightNo=flightNo;
		this.airline=airline;
		this.journeyDetail = journeyDetail;
		this.startTime=startTime;
		this.arrivalTime=arrivalTime;
		this.price=price;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo=flightNo;
	}
	
	public String getAirline() {
		return airline;
	}
	public void SetAirline(String airline) {
		this.airline=airline;
	}
	public JourneyDetails getJourneyDetail() {
		return journeyDetail;
	}
	public void setJourneyDetail(JourneyDetails journeyDetail) {
		this.journeyDetail=journeyDetail;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime=startTime;
	}	
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime=arrivalTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price=price;
	}

}
