package parallelExecutionandDataListner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;



public class Retrylogic implements IRetryAnalyzer {	

    int counter = 0;
    int maxRetry = 3;
	public boolean retry(ITestResult result) {
		
		   if (counter < maxRetry) {

	            counter++;
	            
	         
	            return true;	
		   }
	            return false;
	}


}

