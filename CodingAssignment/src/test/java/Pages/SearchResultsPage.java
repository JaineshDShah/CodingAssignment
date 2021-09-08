package Pages;

import org.openqa.selenium.support.FindBy;
import Models.ItineraryDetails;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
	// Webelements for the page
	@FindBy(xpath = "//div[@class='Container']/h3")
	public WebElement pageHeader;
	@FindBy(xpath = "//table")
	public WebElement tblSearchResults;

	// Actions for the page

	// This method fetches the list of records displayed as a result of search on
	// previous page
	public List<ItineraryDetails> getSearchResults() {
		List<ItineraryDetails> listSearchResults = new ArrayList<ItineraryDetails>();
		try {
			List<WebElement> listRows = tblSearchResults.findElements(By.xpath("//tr"));

			// for-loop to iterate for number of rows in the search result except the header
			for (int counter = 1; counter < listRows.size(); counter++) {
				// fetching each cell of the given row into a list of elements
				List<WebElement> listCells = listRows.get(counter).findElements(By.xpath(".//td"));

				// Setting the value of each cell into respective properties of the object
				ItineraryDetails searchRecord = new ItineraryDetails();
				searchRecord.setFlightNo(listCells.get(1).getText());
				searchRecord.SetAirline(listCells.get(2).getText());
				searchRecord.setStartTime(listCells.get(3).getText());
				searchRecord.setArrivalTime(listCells.get(4).getText());
				searchRecord.setPrice(listCells.get(5).getText());
				listSearchResults.add(searchRecord);
				searchRecord = null;
			}
			return listSearchResults;
		} catch (Exception ex) {
			listSearchResults = null;
			return listSearchResults;
		}
	}

	public void selectFlightByFlightNo(String flightNo) {

		List<WebElement> lstRows = tblSearchResults.findElements(By.xpath("//tr"));
		// for-loop to iterate for number of rows in the search result except the header

		for (int counter = 1; counter < lstRows.size(); counter++) {
			List<WebElement> listCells = lstRows.get(counter).findElements(By.xpath(".//td"));

			if (listCells.get(1).getText().equals(flightNo)) {
				listCells.get(0).click();
				break;
			}

		}
	}

}
