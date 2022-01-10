package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.BaseClass;





public class Login  {

	public WebDriver driver;
	public Login lp;
	
	public Login(WebDriver rdriver) {	

		
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
		
		 
		this.driver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(id = "Email")
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "Password")
	WebElement txtPass;

	@FindBy(how = How.TAG_NAME, using = "button")
	private WebElement btnLogIn;

	@FindBy(xpath = "")
	WebElement btnLogout;
	

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement btnLogoutActuals;
	

	@FindBy(xpath = "//a[@href='/Admin']//i[1]")
	WebElement lblDashBoard;


	public void enterUserName(String email) {

		txtEmail.clear();
		txtEmail.sendKeys(email);

	}

	public void enterPassword(String pwd) {

		txtPass.clear();
		txtPass.sendKeys(pwd);

	}

	public void clickLoginButton() throws Exception {

		btnLogIn.click();
		Thread.sleep(2000);

	}

	public String getAppTitle() {

		return driver.getTitle();
	}

	public boolean verifyAppLogo() {

		return lblDashBoard.isDisplayed();
	}

	public void clickLogoutFail() {
		
		btnLogout.click();
	}
		
	
	public void clickLogoutPass() {
			
				
		WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));
		btnLogoutActuals.click();

		

	}
	


	}
	
	


