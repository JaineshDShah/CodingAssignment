package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	public static BookingSearchPage bookingSearchPage;
	public static SearchResultsPage searchResultsPage;
	public static ReservationPage reservationPage;
	public static BookingConfirmationPage bookingConfirmationPage;
	
	public void pageSetup(WebDriver driver) {
		bookingSearchPage = org.openqa.selenium.support.PageFactory.initElements(driver, BookingSearchPage.class);
		searchResultsPage = org.openqa.selenium.support.PageFactory.initElements(driver, SearchResultsPage.class);
		reservationPage = org.openqa.selenium.support.PageFactory.initElements(driver, ReservationPage.class);
		bookingConfirmationPage = org.openqa.selenium.support.PageFactory.initElements(driver, BookingConfirmationPage.class);
	}

}
