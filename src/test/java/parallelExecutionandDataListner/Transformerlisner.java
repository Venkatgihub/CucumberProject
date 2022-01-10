package parallelExecutionandDataListner;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.annotations.ITestAnnotation;

public class Transformerlisner  {
	
	  
	    
	    public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod)
	    
	    
	    {
	        annotation.setRetryAnalyzer(parallelExecutionandDataListner.Retrylogic.class);
	        
	        
	    }
	    
	    
	    
	}



