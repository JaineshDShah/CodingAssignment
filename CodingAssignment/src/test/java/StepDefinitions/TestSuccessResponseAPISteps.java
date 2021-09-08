package StepDefinitions;

import Common.HelperVariables;
import Common.Utility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class TestSuccessResponseAPISteps {
	static Response response;
    static String urlPath;
    Utility utility = new Utility();
    
    @When("user sends the get request")
    public void userSendsTheGetRequest() {
    	try {
    		utility.logInfo(HelperVariables.startingStep + "user sends the get request");    		
    		RestAssured.baseURI = utility.readConfig("getAPIEndPoint");
    		response = RestAssured.get();
        
        Assert.assertNotNull(response);
    	} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());
			
		}
    }

    @Then("respone code {int} is received")
    public void responeCodeIsReceived(int arg0) {
    	try {
    		utility.logInfo(HelperVariables.startingStep + "respone code " +arg0+" is received");
        Assert.assertEquals(response.getStatusCode(),arg0);
    	} catch (Exception ex) {
			utility.logError(HelperVariables.failedScenario + this.getClass());
			utility.logError(HelperVariables.errorMessage + ex.getMessage());			
		}
    }
}
