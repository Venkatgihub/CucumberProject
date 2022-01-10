package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearCustomerPages {
	
	public WebDriver driver;
	public SearCustomerPages sp;
	
	public SearCustomerPages(WebDriver Ydriver) {
		
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		// lp =new LoginPage(driver2);
		 
		this.driver = Ydriver;

		PageFactory.initElements(Ydriver, this);
	}
	
	@FindBy(xpath = "//p[text()[normalize-space()='Customers']]")
	WebElement Customersicon;


	// Method3
	@FindBy(how = How.XPATH, using = "//p[text()=' Customers']")
	WebElement Customers;


	@FindBy(xpath = "//h1[text()='Add a new customer']")
	WebElement AddNewTitle;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement AddNew;

	@FindBy(id = "FirstName")
	WebElement firstname;

	@FindBy(id = "LastName")
	WebElement lastname;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement Password;
	
	@FindBy(id = "Gender_Male")
	WebElement gender;

	@FindBy(id = "userNumber")
	WebElement mobile;
	
	@FindBy(id ="Company")
	WebElement Company;

	@FindBy(xpath = "//button[text()[normalize-space()='Save']]")
	WebElement submitBtn;

	@FindBy(id = "AdminComment")
	WebElement admincomment;
	
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement closebtn;
	
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]//ul//li")
	WebElement ErrorMsg;
	String Msg="'Email' must not be empty.";
	
	@FindBy(css = "div.search-text")
	WebElement SearchBtn;
	
	@FindBy(css = "input#SearchEmail")
	WebElement EmailSearch;
	
	@FindBy(css = "button#search-customers")
	WebElement SearchBtn1;
	
	@FindBy(id = "Email")
	WebElement Emaillogin;

	@FindBy(how = How.NAME, using = "Password")
	WebElement PassLogin;

	@FindBy(how = How.TAG_NAME, using = "button")
	private WebElement LogInBtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissable')]")
	WebElement SaveBtsStatus;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissable')]")
	WebElement ErrorMsgwithWronfcredentials;
	
	
	
	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "Password")
	WebElement txtPass;

	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement btnLogIn;

	@FindBy(xpath = "")
	WebElement btnLogout;
	

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement btnLogoutActuals;
	

	@FindBy(xpath = "//a[@href='/Admin']//i[1]")
	WebElement lblDashBoard;
	
	@FindBy(xpath = "//input[contains(@id,'SearchEmail')]")
	WebElement Serchinput;
	
	
	public void LoginEmailinput(String email) {
		
		

			Emaillogin.clear();
			Emaillogin.sendKeys(email);

		}

		public void enterPassword(String pwd) {

			txtPass.clear();
			txtPass.sendKeys(pwd);

		}

		public void clickLoginButton() throws Exception {

			btnLogIn.click();
			Thread.sleep(2000);

		}
	
	public void SearchCustomer() throws Exception {	
		

					
		Customersicon.click();
		Thread.sleep(1000);
		Customers.click();
		Thread.sleep(1000);
		//SearchBtn.click();
		
		
	}
	public void Searchinput(String EmailInput) throws Exception {
		
		
		
		Serchinput.clear();
		Thread.sleep(3000);
		Serchinput.sendKeys(EmailInput);
		Thread.sleep(2000);
		SearchBtn1.click();
	}
	
	public void logout() throws InterruptedException {
		
		driver.findElement(By.xpath("//p[text()=' Dashboard']")).click();
		
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
		btnLogoutActuals.click();
		
		
	}
		
	}
