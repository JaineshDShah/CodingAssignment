package Models;

public class JourneyDetails {
	private String sourcePort;
	private String destinationPort;
	
	public String getSourcePort() {
		return sourcePort;
	}
	public void setSourcePort(String source) {
		this.sourcePort=source;
	}
	public String getDestinationPort() {
		return destinationPort;
	}
	public void setDestinationPort(String destinationPort) {
		this.destinationPort=destinationPort;
	}

	//Default Constructor
	public JourneyDetails() {
		sourcePort="";
		destinationPort="";
	}
	
	//parameterized constructor
	public JourneyDetails(String source, String destination) {
		this.sourcePort=source;
		this.destinationPort=destination;
	}
	
}
