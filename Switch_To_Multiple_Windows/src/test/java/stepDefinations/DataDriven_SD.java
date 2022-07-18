package stepDefinations;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebElement;

import commonMethods.SeleniumSpecificMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.HomePage;
import pages.SeleniumTestExamplesPage;


public class DataDriven_SD {
	
	@Given("user is on {string} page")
	public void user_is_on_home_page_with_title(String expectedPageTitle) {
		SeleniumSpecificMethods.validate_PageTitle(expectedPageTitle);
	}
	
	
	@When("user clicks on {string} page")
	public void user_clicks_on_page(String string) {
	    HomePage obj_HomepPage =new HomePage(SeleniumSpecificMethods.getDriver());
	    obj_HomepPage.click_link();
	}
	@When("user enters names on text box and clicks on Submit button")
	public void user_enters_on_text_box_and_clicks_on_button() {

	SeleniumTestExamplesPage obj_SeleniumTestExamplesPage=new SeleniumTestExamplesPage(SeleniumSpecificMethods.getDriver());
	obj_SeleniumTestExamplesPage.fillTheForm();
	}
	
	@When("user enters names on text box as per {int} and clicks on Submit button")
	public void user_enters_names_on_text_box_as_per_and_clicks_on_submit_button(Integer rowNumber) {
		SeleniumTestExamplesPage obj_SeleniumTestExamplesPage=new SeleniumTestExamplesPage(SeleniumSpecificMethods.getDriver());
		obj_SeleniumTestExamplesPage.filltheForm(rowNumber);
	}
	



}
