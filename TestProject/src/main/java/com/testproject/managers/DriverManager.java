package com.testproject.managers;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testproject.enums.EDriverType;
import com.testproject.enums.EEnvironmentMode;
import com.testproject.systemconfigurations.GlobalParameters;

import org.openqa.selenium.edge.EdgeDriver;



public class DriverManager {
	private WebDriver driver;
	private static EDriverType driverType;
	private static EEnvironmentMode environmentMode;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
	
	public DriverManager() {
		driverType = GlobalParameters.getBrowser();
		environmentMode = GlobalParameters.getEnvironmentMode();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentMode) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : 
        	System.setProperty(FIREFOX_DRIVER_PROPERTY,getFireFoxDriver() );   
        	driver = new FirefoxDriver(); 
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, getChromeDriver());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.setHeadless(false);
            driver = new ChromeDriver(options);
    		break;
        case EDGE : 
        	System.setProperty(EDGE_DRIVER_PROPERTY, getEdgeDriver());
        	driver = new EdgeDriver();
    		break;
		default:
			break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(GlobalParameters.WAIT_TIMEOUT)));
		return driver;
	}	
	
	public static String getChromeDriver() {
		return new File("").getAbsolutePath() + "/src/test/resources/drivers/chromedriver.exe";
	}
	
	public static String getFireFoxDriver() {
		return new File("").getAbsolutePath() + "/src/test/resources/drivers/geckodriver.exe";
	}

	public static String getEdgeDriver() {
		return new File("").getAbsolutePath() + "/src/test/resources/drivers/msedgedriver.exe";
	}

	public void quitDriver() {
		driver.close();
		driver.quit();	
	}
}
