package testRunnerAllureParallelScenarios1;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/featureFolderAllureParallelScenarios1",
        plugin = {"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "testng:target/cucumber-reports/testng.xml"},
        glue = "stepDefinationAllureParallelScenarios1",
        monochrome = true,
        publish = true
        
)

//@Test // Add TestNG's Test annotation here

public class TestRunnerAllureParallelScenarios1 extends AbstractTestNGCucumberTests {
	
	
    // ✅ This enables parallel scenario execution within each browser test
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
        
       }
