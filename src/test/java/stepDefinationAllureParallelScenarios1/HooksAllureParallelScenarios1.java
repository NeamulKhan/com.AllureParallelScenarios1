package stepDefinationAllureParallelScenarios1;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilityAllurePrallelScenarios1.BaseClassAllureParallelScenarios1;

public class HooksAllureParallelScenarios1 extends BaseClassAllureParallelScenarios1 {
		
	private static final Logger logger = LoggerFactory.getLogger(HooksAllureParallelScenarios1.class);
	
	    @Before
	    public void setup(Scenario scenario) {
	    	
	    	logger.info("==== STARTING Scenario: {} ====", scenario.getName());
	      allureParallelScenarios1_initializeDriver();
	    //  System.out.println("Running scenario on Thread ID: " + Thread.currentThread().getId());
	      logger.info("====Running scenario on Thread ID: ====" + Thread.currentThread().getId());
	    }
	
	
	
	@After
	    public void tearDown(io.cucumber.java.Scenario scenario) {
		  
		 if (scenario.isFailed()) {
		        logger.error("Scenario failed: {}", scenario.getName());
		        logger.error("!!!! FAILED Scenario: {} !!!!", scenario.getName());

	            byte[] screenshot = ((TakesScreenshot) BaseClassAllureParallelScenarios1.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failure Screenshot");
	        }else {
	            logger.info("Scenario passed: {}", scenario.getName());
	            logger.info("==== PASSED Scenario: {} ====", scenario.getName());
	        }
		 
	        BaseClassAllureParallelScenarios1.quitDriver();
	        System.out.println("---------------------------------------");
	    }

}
