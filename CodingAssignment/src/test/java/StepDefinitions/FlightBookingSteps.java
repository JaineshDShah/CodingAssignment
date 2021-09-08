package StepDefinitions;

import java.util.List;
import Pages.PageFactory;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;
import io.cucumber.java.en.And;
import Common.HelperVariables;
import Common.Utility;
import Models.*;
import Models.JourneyDetails;

public class FlightBookingSteps {	

	Utility utility = new Utility();
	JourneyDetails journeyDetail = new JourneyDetails();

	@Given("user has launched the travel booking page")
	public void user_has_launched_the_travel_booking_page() {
		try {
			// logging the start of steps execution
			utility.logInfo(HelperVariables.startingScenario + this.getClass());

			utility.logInfo(Feature.class.descriptorString() + " started");
			utility.launchBrowser(utility.readConfig("browser"));
			new PageFactory().pageSetup(Utility.driver);
			utility.NavigateToWebURL(utility.readConfig("webURL"));
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Given("user selects the source as {string}")
	public void user_selects_the_source_as(String source) {
		try {
			utility.logInfo(HelperVariables.startingStep + "user selects the source as {string}");
			journeyDetail.setSourcePort(source);
			PageFactory.bookingSearchPage.selectSourcePort(journeyDetail);
			utility.logInfo("User has selected source port");
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@And("user selects the destination as {string}")
	public void user_selects_the_destination_as(String destination) {
		try {
			utility.logInfo(HelperVariables.startingStep + "user selects the destination as {string}");
			journeyDetail.setDestinationPort(destination);
			PageFactory.bookingSearchPage.selectDestinationPort(journeyDetail);
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@And("clicks on Search button")
	public void clicks_on_search_button() {
		try {
			utility.logInfo(HelperVariables.startingStep + "clicks_on_search_button()");
			PageFactory.bookingSearchPage.clickOnFindFlights();
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Then("user is displayed with the search results")
	public void user_is_displayed_with_the_search_results() {
		try {
			utility.logInfo(HelperVariables.startingStep + "user_is_displayed_with_the_search_results()");
			List<ItineraryDetails> lstItinerary = PageFactory.searchResultsPage.getSearchResults();
			
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Then("user selects a flight with flight number {string}")
	public void user_selects_a_flight_with_flight_number(String flightNo) {
		try {
			utility.logInfo(HelperVariables.startingStep + "user selects a flight with flight number {string}");
			PageFactory.searchResultsPage.selectFlightByFlightNo(flightNo);
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Then("user is navigated to the flight reservation form")
	public void user_is_navigated_to_the_flight_reservation_form() {
		try {
			utility.logInfo(HelperVariables.startingStep + "user is navigated to the flight reservation form");
			PageFactory.reservationPage.validatePageLoad();
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Then("user fills the form with details {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void user_fills_the_form_with_details(String firstName, String lastName, String addressLine, String city,
			String state, String zipCode, String cardType, String creditCardNumber, String month, String year,
			String nameOnCard, String rememberMe) {

		try {
			utility.logInfo(HelperVariables.startingStep + "user fills the form with details");
			PassengerDetails passengerInfo = new PassengerDetails(firstName, lastName);
			Address addressInfo = new Address(addressLine, city, state, Integer.parseInt(zipCode));
			PaymentDetails paymentInfo = new PaymentDetails(cardType, Long.parseLong(creditCardNumber),
					Integer.parseInt(month), Integer.parseInt(year), nameOnCard);

			PageFactory.reservationPage.provideAddressDetails(addressInfo);
			PageFactory.reservationPage.providePassengerDetails(passengerInfo);
			PageFactory.reservationPage.provideCardDetails(paymentInfo);
			PageFactory.reservationPage.selectOrDeselectCheckBoxToRemember(Boolean.parseBoolean(rememberMe));
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@And("clicks on Purchase Flight")
	public void clicks_on_purchase_flight() {
		try {
			utility.logInfo(HelperVariables.startingStep + "clicks_on_purchase_flight()");
			PageFactory.reservationPage.clickOnPurchaseButton();
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}

	@Then("user is navigated to the confirmation page")
	public void user_is_navigated_to_the_confirmation_page() {
		try {
			utility.logInfo(HelperVariables.startingStep + "user is navigated to the confirmation page");
			PageFactory.bookingConfirmationPage.validatePageLoad();
			PageFactory.bookingConfirmationPage.verifyPageHeader();
			BookingDetails bookingDetails = PageFactory.bookingConfirmationPage.getBookingDetails();
			PageFactory.bookingConfirmationPage.validateBookingID(bookingDetails);
			utility.quitExecution();
		} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			utility.quitExecution();
		}
	}
}
