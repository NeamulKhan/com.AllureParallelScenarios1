package utilityAllureParallelScenarios1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BaseClassAllureParallelScenarios1 {
	
	public static Properties allureParallelScenarios1_prop;
	public static WebDriverWait wait;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<String>osDetails = new ThreadLocal<>();
	
	private static Logger logger = LoggerFactory.getLogger(BaseClassAllureParallelScenarios1.class);
	
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
			
			String browser = allureParallelScenarios1_prop.getProperty("browser");
			
			//Get OS details
			
			String osName = System.getProperty("os.name");
			String osVersion = System.getProperty("os.version");
			String osArch = System.getProperty("os.arch");
			String osInfo = osName + " " + osVersion + " (" + osArch + ")";
			
			osDetails.set(osInfo); //Store OS details in ThreadLocal
			
		//	logger.info("Launching test on browser: {}, OS: {}", osDetails.get());
			
			logger.info("**** Setting up WebDriver for browser: {} on OS: {} ****", browser, osInfo);
		
	//	String browser = System.getProperty("browser", allureParallelScenarios1_prop.getProperty("browser"));  
	
	//	System.out.println("Thread ID: " + Thread.currentThread().getId() + ", Browser: " + browser);
		
	//	logger.info("Thread ID: " + Thread.currentThread().getId() + ", Browser: " + browser);
		
		 if (driver.get() == null) {
			 
		 
	            switch (browser.toLowerCase()) {
	            
	                case "chrome":
	                	logger.info("Initializing Chrome browser... on Thread ID: " + Thread.currentThread().getId());
	                	//System.out.println("Initializing Chrome browser...");
	                    driver.set(new ChromeDriver());
	                    break;
	               
	                case "edge":
	                	logger.info("Initializing Edge browser... on Thread ID: " + Thread.currentThread().getId());
	                //	System.out.println("Initializing Edge browser...");
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
		
		//Getter method to retrieve OS details
		public static String getOS() {
								
			return osDetails.get();
		}	
		
		public static void allureParallelScenarios1_launchURL() {
			
		//	logger.info("Launching URL: {}",allureParallelScenarios1_prop.getProperty("browser"));
		//	logger.info("Launching URL on browser: {}", getBrowser());
			
			logger.info("Launcing URL on ThreadID: " + Thread.currentThread().getId() + ", Browser: " + allureParallelScenarios1_prop.getProperty("browser"));
			
			getDriver().get(allureParallelScenarios1_prop.getProperty("base.url"));
		}
	
		 public static void quitDriver() {
			 logger.info("Closing browser: " + allureParallelScenarios1_prop.getProperty("browser") + ", on ThreadID: " + Thread.currentThread().getId());
		//	 logger.info("Closing browser: {}", getBrowser());
		        if (driver.get() != null) {
		            driver.get().quit();
		            driver.remove();// remove from ThreadLocal to avoid memory leaks
					System.out.println("Test completed successfully and browser closed.");
		        }
		        if (osDetails.get() != null) {
		            osDetails.remove();
		        }	
		        else {
			        System.out.println("No active driver found to quit.");
			    }
		    }
		}
	


