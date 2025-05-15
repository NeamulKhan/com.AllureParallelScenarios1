package testRunnerAllureParallelScenarios1;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilityAllureParallelScenarios1.EnvironmentWriterAllureParallelScenarios1;


@CucumberOptions(
        features = "src/test/resources/featureFolderAllureParallelScenarios1",
        plugin = {"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "testng:target/cucumber-reports/testng.xml"},
        glue = "stepDefinationAllureParallelScenarios1",
        monochrome = true,
        publish = true
        
)

public class TestRunnerAllureParallelScenarios1 extends AbstractTestNGCucumberTests {
	
	

    // ✅ One-time setup to write environment info
    @BeforeClass
    public void beforeSuite() {
        EnvironmentWriterAllureParallelScenarios1.writeAllureEnvironmentInfo();
    }
	
	
    // ✅ This enables parallel scenario execution within each browser test
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
        
       }
