package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.SeleniumSpecificMethods;
import utility.ExcelReader;

public class SeleniumTestExamplesPage {

	WebDriver driver;
	public SeleniumTestExamplesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//input[@name='text']")
	private WebElement text_Input_Text_Here;

	@FindBy(xpath = "//textarea[@name='textarea']")
	private WebElement textarea;
	
	
	@FindBy(xpath = "//input[@id='submitbtn']")
	private WebElement button_submit;
	


	public void fillTheForm(String textToEnter) {
		SeleniumSpecificMethods.enterText_TextField(text_Input_Text_Here, textToEnter);
		SeleniumSpecificMethods.click(button_submit);

	}


	public void fillTheForm() {

		

		for (HashMap<String,String> singleData : ExcelReader.getExcelData(ExcelReader.getSheetByName())) {


			SeleniumSpecificMethods.enterText_TextField(text_Input_Text_Here, singleData.get("username"));

			SeleniumSpecificMethods.enterText_TextField(textarea, singleData.get("password"));

			SeleniumSpecificMethods.click(button_submit);
		}
	}
	
	public void filltheForm(int rowNumber) {
		
		
		
		SeleniumSpecificMethods.enterText_TextField(text_Input_Text_Here, ExcelReader.getRowData(ExcelReader.getSheetByName(),rowNumber).get("username"));

		SeleniumSpecificMethods.enterText_TextField(textarea, ExcelReader.getRowData(ExcelReader.getSheetByName(),rowNumber).get("password"));

		SeleniumSpecificMethods.click(button_submit);
	
	}
}
