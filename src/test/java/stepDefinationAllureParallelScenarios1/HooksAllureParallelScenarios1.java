package stepDefinationAllureParallelScenarios1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilityAllurePrallelScenarios1.BaseClassAllureParallelScenarios1;

public class HooksAllureParallelScenarios1 extends BaseClassAllureParallelScenarios1 {
		
	 
	    @Before
	    public void setup() {
	       
	      allureParallelScenarios1_initializeDriver();
	      System.out.println("Running scenario on Thread ID: " + Thread.currentThread().getId());
	      
	    }
	
	
	
	@After
	    public void tearDown(io.cucumber.java.Scenario scenario) {
		  
		 if (scenario.isFailed()) {
	            byte[] screenshot = ((TakesScreenshot) BaseClassAllureParallelScenarios1.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failure Screenshot");
	        }
	        BaseClassAllureParallelScenarios1.quitDriver();
	        System.out.println("---------------------------------------");
	    }

}
