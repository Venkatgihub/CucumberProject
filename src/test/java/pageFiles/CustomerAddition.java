package pageFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CustomerAddition extends BaseDetailsCucumber { 
	
		WebDriver driver;
		
		public static ExcelUtils excelUtils = new ExcelUtils();
		
		//static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;
		//static String excelWebDriver driverFilePath = Constants.Path_TestData + Constants.File_TestData;

			public CustomerAddition(WebDriver cdriver) {
				
				this.driver = cdriver;
				PageFactory.initElements(cdriver, this);
			// TODO Auto-generated constructor stub
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
			WebElement txtEmail;

			@FindBy(how = How.NAME, using = "Password")
			WebElement txtPass;

			@FindBy(how = How.TAG_NAME, using = "button")
			private WebElement btnLogIn;
			
			@FindBy(xpath = "//div[contains(@class,'alert alert-success alert-dismissable')]")
			WebElement SaveBtsStatus;
			
			@FindBy(xpath = "//div[contains(@class,'alert alert-danger alert-dismissable')]")
			WebElement ErrorMsgwithWronfcredentials;
			
			
			
			
			
			


			public void ClickCustomericon() throws InterruptedException {
				
				
				txtEmail.clear();
				txtEmail.sendKeys("admin@yourstore.com");
				txtPass.clear();
				txtPass.sendKeys("admin");
				btnLogIn.click();
				Customersicon.click();
				Thread.sleep(1000);
				Customers.click();
				//AddNew.click();
			}
			
			public void CustomerTestData() throws InterruptedException, IOException {
				excelUtils.setExcelFile(excelFilePath,"Sheet1");
				for (int i = 6; i <= excelUtils.getRowCountInSheet(); i++) {
					// Enter the values read from Excel in firstname,lastname,mobile,email,address
					AddNew.click();
					Thread.sleep(2000);
					firstname.clear();
					firstname.sendKeys(excelUtils.getCellData(i, 0));
					Thread.sleep(2000);
					lastname.clear();
					lastname.sendKeys(excelUtils.getCellData(i, 1));
					Thread.sleep(2000);
					email.clear();
					String emails = randomestring() + "@gmail.com";
					email.sendKeys(emails);
					Password.clear();
					Password.sendKeys(excelUtils.getCellData(i, 2));
					Company.clear();
					Company.sendKeys(excelUtils.getCellData(i, 3));
				
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", gender);

					Thread.sleep(2000);
					js.executeScript("arguments[0].click();", submitBtn);
					WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]"));

				
					Thread.sleep(2000);
					if (confirmationMessage.isDisplayed()) {
						
						
					
						excelUtils.setCellValue(i, 6, "PASS", excelFilePath);
					} else {
				
						excelUtils.setCellValue(i, 6, "FAIL", excelFilePath);
					}

				
					Thread.sleep(2000);
					
					System.out.println(confirmationMessage);
					js.executeScript("arguments[0].click();", closebtn);
					
					 }

			}
			
			public void SaveCustomer() {
				
				//String SavedMsg = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]")).getText();
				//String Status= cp.SaveBtsStatus.getText();
				
//				System.out.println(SavedMsg);
//				String ActualTxt="The new customer has been added successfully.";
//				Assert.assertTrue(SavedMsg.contains(ActualTxt), "Customer Details Saved Successfully");
//				
			}

			public void CustomerAdditionwithWrongData() throws InterruptedException {
				Thread.sleep(2000);
				AddNew.click();
				submitBtn.click();
				String WrongCredentials=ErrorMsgwithWronfcredentials.getText();
				String actualErrorString="Valid Email is required for customer to be in 'Registered' role";
				Assert.assertTrue(WrongCredentials.endsWith(actualErrorString));
					
					Customers.click();
					SearchBtn.click();
				}
				
			
		
			
			public void CloseAPP() {
				
				driver.close();
			}
			
		}


		



