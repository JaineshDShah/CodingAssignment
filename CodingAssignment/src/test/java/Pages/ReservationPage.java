package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import Common.Utility;
import Models.Address;
import Models.PassengerDetails;
import Models.PaymentDetails;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ReservationPage {
	Utility utility = new Utility();
	
	//WebElements on Reservation page
	@FindBy(xpath = "//input[@id='inputName']")
	public WebElement txtname;
	@FindBy(xpath = "//input[@id='address']")
	public WebElement txtaddress;
	@FindBy(xpath = "//input[@id='city']")
	public WebElement txtcity;
	@FindBy(xpath = "//input[@id='state']")
	public WebElement txtstate;
	@FindBy(xpath = "//input[@id='zipCode']")
	public WebElement txtzipCode;
	@FindBy(xpath = "//select[@id='cardType']")
	public WebElement ddlcardType;
	@FindBy(xpath = "//input[@id='creditCardNumber']")
	public WebElement txtcreditCardNumber;
	@FindBy(xpath = "//input[@id='creditCardMonth']")
	public WebElement txtcreditCardMonth;
	@FindBy(xpath = "//input[@id='creditCardYear']")
	public WebElement txtcreditCardYear;
	@FindBy(xpath = "//input[@id='nameOnCard']")
	public WebElement txtnameOnCard;
	@FindBy(xpath = "//input[@id='rememberMe']")
	public WebElement chkboxRememberMe;
	@FindBy(xpath = "//input[@value='Purchase Flight']")
	public WebElement btnPurchaseFlight;
	
	//Actions on Reservation page	
	public void validatePageLoad() {
		Assert.assertTrue(utility.waitForPageLoad(btnPurchaseFlight));
	}
	
	public void providePassengerDetails(PassengerDetails passenger) throws InterruptedException {
		txtname.sendKeys(passenger.getFirstName()+" "+passenger.getLastName());
		
	}
	
	public void provideAddressDetails(Address address) {
		
		this.txtaddress.sendKeys(address.getAddress());
		txtcity.sendKeys(address.getCity());
		txtstate.sendKeys(address.getState());
		txtzipCode.sendKeys(String.valueOf(address.getZipCode()));
	}
	
	public void provideCardDetails(PaymentDetails cardDetails) {
		
		Select cardTypeDropdown = new Select(this.ddlcardType);
		
		cardTypeDropdown.selectByVisibleText(cardDetails.getCardType().trim());
		txtcreditCardNumber.clear();
		txtcreditCardNumber.sendKeys(String.valueOf(cardDetails.getCardNumber()));
		txtcreditCardMonth.clear();
		txtcreditCardMonth.sendKeys(String.valueOf(cardDetails.getMonth()));
		txtcreditCardYear.clear();
		txtcreditCardYear.sendKeys(String.valueOf(cardDetails.getYear()));
		txtnameOnCard.clear();
		txtnameOnCard.sendKeys(cardDetails.getNameOnCard());
	}
	
	public boolean selectOrDeselectCheckBoxToRemember(boolean selection) {
		boolean flag=false;
		if(chkboxRememberMe.isSelected() && selection==false) {
			chkboxRememberMe.click();
			flag=true;
		}
		if(!chkboxRememberMe.isSelected() && selection==true) {
			chkboxRememberMe.click();
			flag=true;
		}		
		return flag;		
	}
	
	public void clickOnPurchaseButton() {
		btnPurchaseFlight.click();
	}
	
	
}
