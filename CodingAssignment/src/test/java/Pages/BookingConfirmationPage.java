package Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Common.HelperVariables;
import Models.BookingDetails;
import Common.Utility;

public class BookingConfirmationPage {
	@FindBy(xpath = "//h1")
	public WebElement header;
	@FindBy(xpath = "//table[@class='table']/tbody")
	public WebElement tblConfirmationDetails;

	Utility utility = new Utility();

	public void validatePageLoad() {
		Assert.assertTrue(utility.waitForPageLoad(header));
	}

	public void verifyPageHeader() {
		try {
			Assert.assertEquals(HelperVariables.confirmationPageTitle, header.getText());
		} catch (Exception ex) {

		}
	}

	public void validateBookingID(BookingDetails bookingDetails) {
		try {
			if (StringUtils.isBlank(bookingDetails.getConfirmationID()))
				Assert.fail("Booking Confirmation ID is a white space, null or empty");
		} catch (Exception ex) {

		}
	}

	public BookingDetails getBookingDetails() {
		BookingDetails bookingDetails = new BookingDetails();
		try {
			System.out.println("1");
			List<WebElement> listRows = tblConfirmationDetails.findElements(By.xpath(".//tr"));

			// Iterating for the number of rows in the table
			for (int counter = 0; counter < listRows.size(); counter++) {

				// Fetching the cells from the row into an array of individual elements
				List<WebElement> listCells = listRows.get(counter).findElements(By.xpath(".//td"));				

				// Setting the value from the row into appropriate property of the object
				switch (listCells.get(0).getText()) {
				case "Status":
					bookingDetails.setStatus(listCells.get(1).getText());
					break;
				case "Amount":
					// Splitting the amount and currency from the concatenated string
					String[] amount = listCells.get(1).getText().split(" ");

					bookingDetails.setAmount(Double.parseDouble(amount[0]));
					break;
				case "Id":
					bookingDetails.setConfirmationID(listCells.get(1).getText());
					break;
				case "Expiration":
					bookingDetails.setExpiration(listCells.get(1).getText());
					break;
				case "Auth Code":
					bookingDetails.setAuthCode(listCells.get(1).getText());
					break;
				case "Date":
					String strDate = listCells.get(1).getText();
					Date date = new SimpleDateFormat(HelperVariables.bookingDateFormat).parse(strDate);
					break;
				case "Card Number":
					bookingDetails.setCardNumber(listCells.get(1).getText());
					break;
				}
			}
			return bookingDetails;
		} catch (Exception ex) {
			bookingDetails = null;
			return bookingDetails;
		}
	}
}
