package pageActionAllureParallelScenarios1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import pageLocatorAllureParallelScenarios1.HomePageLocatorAllureParallelScenarios1;
import stepDefinationAllureParallelScenarios1.ImageSliderAllureParallelScenarios1;
import utilityAllureParallelScenarios1.BaseClassAllureParallelScenarios1;

public class HomepageActionAllureParallelScenarios1 extends BaseClassAllureParallelScenarios1 {
	
	HomePageLocatorAllureParallelScenarios1 homePageLocatorAllureParallelScenarios1 = new HomePageLocatorAllureParallelScenarios1 ();
	
	private static final Logger logger = LoggerFactory.getLogger(ImageSliderAllureParallelScenarios1.class);
	
	public void homepage_image_slider_should_be_visible() {
		
		logger.debug("Verifying home page image slider is visible");
		
		boolean verifyImageSliderVisible = homePageLocatorAllureParallelScenarios1.imageSliderContainer.isDisplayed();
		Assert.assertTrue(verifyImageSliderVisible);
		
	//	logger.info("Expected Title: {}, Actual Title: {}", expected, actual);
	}
	
	public void wait_for_the_image_slider_to_change() {
		
		 wait.until(ExpectedConditions.visibilityOf(homePageLocatorAllureParallelScenarios1.activeImage));
	}
	
	public void displayed_image_should_be_different_from_the_previous_one() {
		
		WebElement currentImage = homePageLocatorAllureParallelScenarios1.activeImage;
		WebElement newImage = homePageLocatorAllureParallelScenarios1.activeImage;
		Assert.assertNotEquals(currentImage.getAttribute("src"),newImage.getAttribute("src"),"Image did not change");
	
		logger.info("currentImage: {}, newImage: {}", currentImage, newImage);
	}
	
}
