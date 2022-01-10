package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageFiles.CustomerAddition;
import pageFiles.Login;

public class StepDfnsCustomerAddition {
	
	

	public WebDriver driver;;
	CustomerAddition cp;
	Login lp;
	public Properties configProp;
	
	@Before
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
	
	@Given("User can View the Customer Addition Icon in DashBoard {string}")
	public void user_can_View_the_Customer_Addition_Icon_in_DashBoard(String URL) {
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		cp = new CustomerAddition(driver);
		driver.get(URL);	
		//cp = new CustomerAddition(driver);
	    
	}

	@When("After Clicking the ADD Customer User can view the input Data")
	public void after_Clicking_the_ADD_Customer_User_can_view_the_input_Data() throws Exception {
		
		cp.ClickCustomericon();
		
//		lp.enterUserName("admin@yourstore.com");
//		lp.enterPassword("admin");
//		lp.clickLoginButton();
//		
	
	
	}

	@When("Maditory Fields verification")
	public void maditory_Fields_verification() throws InterruptedException, IOException {
		
		cp.CustomerTestData();
	 
	}

	@Then("User can Save the details")
	public void user_can_Save_the_details() {
	
	cp.SaveCustomer();
	
	}

	@Then("If user not have a valid data Error Msg {string} Should be Display")
	public void if_user_not_have_a_valid_data_Error_Msg_Should_be_Display(String string) throws InterruptedException {
		
		
		cp.CustomerAdditionwithWrongData();
	   
	}

	@Then("User can View the Added Customer Details")
	public void user_can_View_the_Added_Customer_Details() {
		
		
	  cp.CloseAPP();
	  
	}

	

}
