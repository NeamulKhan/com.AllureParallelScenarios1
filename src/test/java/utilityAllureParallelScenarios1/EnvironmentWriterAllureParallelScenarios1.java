package utilityAllureParallelScenarios1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentWriterAllureParallelScenarios1 {
	
	
	public static void writeAllureEnvironmentInfo() {
        Properties props = new Properties();
        props.setProperty("Environment", "QA");
     //   props.setProperty("Browser", "Chrome");
        props.setProperty("Platform", System.getProperty("os.name"));
        props.setProperty("Java Version", System.getProperty("java.version"));
        
        String browser = System.getProperty("browser", "Chrome");
        props.setProperty("Browser", browser);

        try {
            FileOutputStream fos = new FileOutputStream("allure-results/environment.properties");
            props.store(fos, "Allure Environment Info");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
