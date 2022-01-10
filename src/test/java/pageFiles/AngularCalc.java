package pageFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AngularCalc {
	
	public WebDriver driver;
	@Test
	public void CalcValidation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://juliemr.github.io/protractor-demo");
		driver.findElement(By.cssSelector("input[ng-model=\"first")).sendKeys("1221");
		driver.findElement(By.cssSelector("input[ng-model='second']")).sendKeys("2122");
		String X= driver.findElement(By.cssSelector("#gobutton")).getText();
		System.out.println(X);
		Assert.assertEquals(X, "1233");
		
		
		
	

}
}