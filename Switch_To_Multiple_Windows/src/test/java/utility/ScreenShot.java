package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import commonMethods.SeleniumSpecificMethods;
import io.cucumber.java.Scenario;

public class ScreenShot {


	public static void takeScreenshotForFailTestCase(Scenario scenario) throws IOException {

		


			scenario.log(scenario.getName()+" scenario failed");

			//converting the WebDriver interface to TakesScreenshot interface and calling getScreenshotAs method
			File screenshot_with_scenario_name = ((TakesScreenshot)SeleniumSpecificMethods.getDriver()).getScreenshotAs(OutputType.FILE);
			
			//storing the scenario name in a veriable after replacing spaces with _
			String screenshotName= scenario.getName().replace(" ", "_");
			
			//getting the date format to include in the destination file name
			Date date=new Date();
			SimpleDateFormat obj_SimpleDateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			String string_Date=obj_SimpleDateFormat.format(date);

			File destinationPath=new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+"_"+string_Date+".png");
			
			
			Files.copy(screenshot_with_scenario_name.toPath(), destinationPath.toPath());

			scenario.log(scenario.getName()+" screenshot saved in "+destinationPath.toString());

			
			
			
			byte[] fileContent = Files.readAllBytes(screenshot_with_scenario_name.toPath());
			
			//byte[] screenShot=null;
			//try {
			//	screenShot = FileUtils.readFileToByteArray(screenshot_with_scenario_name);
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}


			//
			//to attach the screenshot to the report
			//scenario.attach(screenShot,"image/png",scenario.getName());




			//Copy taken screenshot from source location to destination location

			//try {
			//	
			//	} catch (IOException e) {
			//		e.printStackTrace();
			//	} 

		
	}
	
	
}
