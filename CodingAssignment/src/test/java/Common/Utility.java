package Common;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {	
	public static WebDriver driver;
	
	public static Logger logger = LogManager.getLogger(Utility.class);
	
	public void logInfo(String message) {
		logger.info(message);		
	}
	public void logError(String message) {
		logger.error(message);		
	}

	public String readConfig(String key) {
		String assignmentPath = System.getProperty("user.dir");
		assignmentPath = assignmentPath + "/target/config.properties";
		
		File file = new File(assignmentPath);
		Properties prop = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	public void NavigateToWebURL(String url) {
		driver.navigate().to(url);
	}

	public boolean waitForPageLoad(WebElement webElement) {
		boolean flag = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(webElement));
			flag = true;
			return flag;
		} catch (Exception ex) {
			return flag;
		}
	}

	

	public void launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", readConfig("ChromeDriver"));			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--whitelisted-ips=");
			options.addArguments("chrome.switches", "--ignore-certificate-errors");
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			maximizeBrowser();
			break;
		}
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void quitExecution() {
		driver.quit();
	}

}
