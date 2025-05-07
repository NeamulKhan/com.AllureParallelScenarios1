package utilityAllurePrallelScenarios1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassAllureParallelScenarios1 {
	
	public static Properties allureParallelScenarios1_prop;
	public static WebDriverWait wait;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public BaseClassAllureParallelScenarios1 () {
		
		try {
					
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/allureParallelScenarios1.config/allureParallelScenarios1.properties");
			
			allureParallelScenarios1_prop = new Properties();
			allureParallelScenarios1_prop.load(file);
			
		} catch (FileNotFoundException e) {
		    System.err.println("Properties file not found: " + e.getMessage());
		}
		  catch (IOException e) {
		    System.err.println("Error loading properties file: " + e.getMessage());
		}
		
		}
	
	
	// Ensure method is static to be called before every test scenario
	//public static void allureParallelScenarios1_initializeDriver(String browser) {
	
		public static void allureParallelScenarios1_initializeDriver() {
		
		String browser = System.getProperty("browser", allureParallelScenarios1_prop.getProperty("browser"));  
		System.out.println("Thread ID: " + Thread.currentThread().getId() + ", Browser: " + browser);
				
		 if (driver.get() == null) {
			 
		 
	            switch (browser.toLowerCase()) {
	            
	                case "chrome":
	                	System.out.println("Initializing Chrome browser...");
	                    driver.set(new ChromeDriver());
	                    break;
	               
	                case "edge":
	                	System.out.println("Initializing Edge browser...");
	                    driver.set(new EdgeDriver());
	                    break;
	                    
	                default:
	                    throw new RuntimeException("Invalid browser: " + browser);
	            }
				
		
	
				wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10)); // Initialize WebDriverWait here
				getDriver().manage().window().maximize();
				getDriver().manage().deleteAllCookies();
	
			}
		}
	
		//Getter method to retrieve WebDriver instance
		public static WebDriver getDriver() {
			if (driver.get() == null) {
			throw new IllegalStateException("Driver is not initialized properly.");
		}
		
		return driver.get();
	}
		
		public static void allureParallelScenarios1_launchURL() {
			
			getDriver().get(allureParallelScenarios1_prop.getProperty("base.url"));
		}
	
		 public static void quitDriver() {
		        if (driver.get() != null) {
		            driver.get().quit();
		            driver.remove();// remove from ThreadLocal to avoid memory leaks
					System.out.println("Test completed successfully and browser closed.");
		        }else {
			        System.out.println("No active driver found to quit.");
			    }
		    }
		}
	


