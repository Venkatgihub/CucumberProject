package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageFiles.CustomerAddition;
import pageFiles.ExcelUtils;
import pageFiles.Login;
//import pageFiles.Login;
import pageFiles.SearCustomerPages;




public class BaseClass {

	WebDriver driver;
	public Login lp;
	public  CustomerAddition cp;
	public SearCustomerPages sp;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public Properties configProp;
	

	public static ExcelUtils excelUtils = new ExcelUtils();

	static String excelFilePath = Constants.Path_TestData + Constants.File_TestData;
	
	 @BeforeTest
	    public void startReport() {
	         htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
	         "\test-output\\LT_ExtentReport.html");
	        String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        htmlReporter = new ExtentHtmlReporter(".\\CucumberProject\\NOPPageValidation"+dateName_number+".html");
	        // Create an object of Extent Reports
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	    }

	    // This method is to capture the screenshot and return the path of the
	    // screenshot.
	
	    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        // after execution, you could see a folder "FailedTestsScreenshots" under src
	        // folder
	        String destination = System.getProperty(".\\CucumberProject\\NOPPageValidation") + screenshotName + dateName + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        System.out.println(finalDestination);
	        return destination;
	    }

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	



	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(2000);
		extent.flush();
		driver.quit();

	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		 Logger log = Logger.getLogger("LT_Logger");
	     PropertyConfigurator.configure(".\\CucumberProject\\log4j\\log4j.properties");
	     	if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String screenshotPath = getScreenShot(driver, result.getName());
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}
}


