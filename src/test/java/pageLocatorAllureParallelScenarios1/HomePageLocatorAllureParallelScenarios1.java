package pageLocatorAllureParallelScenarios1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityAllureParallelScenarios1.BaseClassAllureParallelScenarios1;

public class HomePageLocatorAllureParallelScenarios1 extends BaseClassAllureParallelScenarios1 {
	
	public HomePageLocatorAllureParallelScenarios1 () {
		
		PageFactory.initElements(getDriver(),this);	
	}

	@FindBy (xpath="//section//div[contains(@class, 'container')]//div[contains(@class, 'row')]")
	public WebElement imageSliderContainer;
	
	@FindBy (css=".slick-slide.slick-current.slick-active img")
	
	public WebElement activeImage;
}
