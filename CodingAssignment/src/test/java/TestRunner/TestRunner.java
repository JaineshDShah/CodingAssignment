package TestRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"}, plugin= {"pretty","html:target/Cucumber-Html-Reports/CucumberReport.html"},tags= "@AssignmentScenario")

public class TestRunner {
	public Logger logger = LogManager.getLogger(TestRunner.class);
}
