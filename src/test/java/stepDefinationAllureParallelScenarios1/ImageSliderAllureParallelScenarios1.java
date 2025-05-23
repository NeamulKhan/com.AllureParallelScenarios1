package stepDefinationAllureParallelScenarios1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageActionAllureParallelScenarios1.HomepageActionAllureParallelScenarios1;
import utilityAllureParallelScenarios1.BaseClassAllureParallelScenarios1;

public class ImageSliderAllureParallelScenarios1 extends BaseClassAllureParallelScenarios1 {
	
	HomepageActionAllureParallelScenarios1 homepageActionAllureParallelScenarios1 = new HomepageActionAllureParallelScenarios1();
	
	private static final Logger logger = LoggerFactory.getLogger(ImageSliderAllureParallelScenarios1.class);
	
	
	@Given("I am on the website homepage")
	public void i_am_on_the_website_homepage() {
		
	//	logger.info("Thread ID: {} - Verifying homepage title", Thread.currentThread().getId());
		logger.info("Thread ID: {} - Step: Launching homepage", Thread.currentThread().getId());
	    
		allureParallelScenarios1_launchURL();
		logger.info("Home page opened");
		
	}

	@Then("the homepage image slider should be visible")
	public void the_homepage_image_slider_should_be_visible() {
	   
		logger.info("Thread ID: {} - Step: Checking image slider visibility", Thread.currentThread().getId());
		homepageActionAllureParallelScenarios1.homepage_image_slider_should_be_visible();
	//	logger.info("Thread ID: {} - Verified homepage image slider is visible", Thread.currentThread().getId());
		
		logger.info("Image slider is visible at homepage");
	}

	@When("I wait for the image slider to change")
	public void i_wait_for_the_image_slider_to_change() {
		
		logger.info("Waiting for Image slider to change");
	  
		homepageActionAllureParallelScenarios1.wait_for_the_image_slider_to_change();
	}

	@Then("the displayed image should be different from the previous one")
	public void the_displayed_image_should_be_different_from_the_previous_one() {
	   
		homepageActionAllureParallelScenarios1.displayed_image_should_be_different_from_the_previous_one();
	}



}
