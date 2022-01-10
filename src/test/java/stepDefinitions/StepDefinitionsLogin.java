package stepDefinitions;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageFiles.Login;

public class StepDefinitionsLogin {

	
	public ExtentTest logger;
	public Login lp;
	public String Title1;
	public WebDriver driver;
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
	@Given("User Can Enable the Login Credentials by URL {string}")
	public void user_Can_Enable_the_Login_Credentials_by_URL(String URL) throws IOException {
		
		lp = new Login(driver);
		
		//lp = new Login(driver);
		
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		driver.get(URL);
		
		
//	   
		String txt = driver.getTitle();
		System.out.println(txt);

	}

	@When("User Can input the credentials UserName and Password")
	public void user_Can_input_the_credentials_UserName_and_Password() throws Exception {

		
		Thread.sleep(2000);
		String Title1 = driver.getTitle();
		System.out.println(Title1);

		lp.enterUserName("admin@yourstore.com");
		lp.enterPassword("admin");
		lp.clickLoginButton();
//		driver.findElement(By.xpath("//input[contains(@value,'admin@yourstore.com')]")).clear();
//		driver.findElement(By.xpath("//input[contains(@value,'admin@yourstore.com')]")).sendKeys(UserEmail);
//		driver.findElement(By.xpath("//input[contains(@class,'password')]")).clear();
//		driver.findElement(By.xpath("//input[contains(@class,'password')]")).sendKeys(UserPassword);
		//String Tilte1=driver.getTitle();
	}

	@When("Successfully Logged in and Title Verified")
	public void successfully_Logged_in_and_Title_Verified() {

		//driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	}

	@Then("User Can View the DashBoard")
	public void user_Can_View_the_DashBoard() throws InterruptedException {

		//System.out.println(Title1);

		String AfterLoggedIn = driver.getTitle();

		System.out.println(AfterLoggedIn);
		
		//Assert.assertEquals(AfterLoggedIn, Title1, "Pass");

		Thread.sleep(2000);

		driver.findElement(By.linkText("Logout")).click();

		driver.close();
		

	}

}