package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import Models.JourneyDetails;
import org.openqa.selenium.WebElement;

public class BookingSearchPage {

	//Webelements for the page
	 @FindBy(xpath = "//select[@name='fromPort']")
	    public WebElement selectSourceLocation;
	 @FindBy(xpath = "//select[@name='toPort']")
	    public WebElement selectDestinationLocation;
	 @FindBy(xpath = "//input[@value='Find Flights']")
	    public WebElement btnFindFlights;
	 
	 //actions for the page
	public void selectSourcePort(JourneyDetails journey) {
		Select sourceDropdown = new Select(selectSourceLocation);
		sourceDropdown.selectByValue(journey.getSourcePort().trim());
	}
	
	public void selectDestinationPort(JourneyDetails journey) {
		Select sourceDropdown = new Select(selectDestinationLocation);
		sourceDropdown.selectByValue(journey.getDestinationPort().trim());
	}
	
	public void clickOnFindFlights() {
		btnFindFlights.click();
	}
	
}
