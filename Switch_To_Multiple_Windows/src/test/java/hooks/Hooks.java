package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonMethods.SeleniumSpecificMethods;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utility.InvokeBrowser;
import utility.ScreenShot;

public class Hooks {


	public static WebDriver driver;
	public static InvokeBrowser obj_invokBrowser;
	
	//for logging 
	public static final Logger LOGGER=LogManager.getLogger(Hooks.class);
	

	//to open browser and url
	@Before
	public void openBrowserAndUrl() {
		
		obj_invokBrowser=new InvokeBrowser();
	
		LOGGER.info("Invoking the browser");
		
		driver=obj_invokBrowser.openUrl(obj_invokBrowser.setDriver());
		
		LOGGER.info("url opened");
	}
	

	/*@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) SeleniumSpecificMethods.getDriver()).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}*/
	
	
	
	@After(order = 1)
	public void takeAndAttachScreenshotToReports(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
	try {
		//taking screenshot for the failed testcase
		ScreenShot.takeScreenshotForFailTestCase(scenario);
		
		
	} catch (IOException e) {
		System.out.println("please check the screen shot output");
	}

		}
	}

	//to close browser
	@After(order = 0)
	public void closeBrowser() {
		driver.close();
	}

}
