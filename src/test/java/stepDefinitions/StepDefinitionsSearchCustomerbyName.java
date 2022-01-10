package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFiles.IndipendentSearchCustomer;

public class StepDefinitionsSearchCustomerbyName {
	
	public WebDriver Xdriver;
	IndipendentSearchCustomer ic;
	
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		 //WebDriverManager.chromedriver().setup();
		 
			Xdriver=new ChromeDriver();
			
	   
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String URL) {
		
		Xdriver.get(URL);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String Email, String Password) {
		
	   ic.setEmail(Email);
	}

	@When("Click on Login")
	public void click_on_Login() {
	   
	}

	@Then("User can view Dashboad")
	public void user_can_view_Dashboad() {
	   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() {
	  
	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() {
	    
	}

	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
	   
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
	 
	}

	@When("Click on search button")
	public void click_on_search_button() {
	   
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() {
	   
	}

	@Then("close browser")
	public void close_browser() {
	
	}


}
