package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageFiles.CustomerAddition;
//import pageFiles.CustomerAddition;
import pageFiles.Login;
import pageFiles.SearCustomerPages;

public class StepDfnsSearchCustomer {
	
	CustomerAddition cp;
	Login lp;
	public WebDriver driver;
	String Cusdtomerdata;
	
	public SearCustomerPages sp;
	public Properties configProp;
	
	//@Before
	public void setup() throws IOException	{

		configProp= new Properties();
		FileInputStream configPropfile = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\CucumberProject\\src\\test\\test-data\\Config.properties");
		configProp.load(configPropfile);
		String br=configProp.getProperty("browser"); //getting the browser name from config.properties file
		//Launching browser
		if (br.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
		driver = new FirefoxDriver();
		} else if (br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
		driver = new ChromeDriver();
		//driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		 //lp = new Login(driver);
		}
		else if (br.equals("edge")) {
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
		driver = new EdgeDriver();
		}
		}
	
	
	 @Given("^Locate the Search with EMAIL \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	    public void locate_the_search_with_email_somethingsomethingsomethingsomethingsomething(String URL, String Email2, String Email3, String EmailInput, String Email5) throws Throwable {
		
		// WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.get(URL);
			sp = new SearCustomerPages(driver);
			Thread.sleep(2000);
			sp.LoginEmailinput(Email2);
			sp.enterPassword(Email3);
			sp.clickLoginButton();
			sp.SearchCustomer();			
			sp.Searchinput(EmailInput);
	    }

	    @When("^While click on SearchTaB Valid Details should display$")
	    public void while_click_on_searchtab_valid_details_should_display() throws Throwable {
	        
	    	
	    	String Cusdtomerdata= driver.findElement(By.xpath("//td[contains(text(),'admin')]")).getText();
	    	System.out.println(Cusdtomerdata);
	    	
	    	Assert.assertEquals(Cusdtomerdata, "admin@yourStore.com");
	    	
	    	//Assert.assertEquals(Cusdtomerdata,"admin@yourStore.com","Added Customer Validated Successfully");
	    }

	    @Then("^Click on Logout$")
	    public void click_on_logout() throws Throwable {
	    	
	    	//String Cusdtomerdata1= driver.findElement(By.xpath("//td[contains(text(),'admin')]")).getText();
	    	
	    	
	    	Thread.sleep(2000);
	    	
//	    	driver.findElement(By.linkText("Logout")).click();
	    
	       sp.logout();
	       
	    }

	    @And("^Displayed Details and Sear Details should Same$")
	    public void displayed_details_and_sear_details_should_same() throws Throwable {
	    	
	    	System.out.println("Search Customer Validation completed Successfully");
	    	
	    	Thread.sleep(3000);
	    	//driver.close();
	    	
	    	driver.quit();
	       
	    }

}
