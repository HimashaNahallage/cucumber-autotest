package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:/Users/Himasha/IdeaProjects/cucumber-automation/src/test/resources/features/LoginPage.feature"},
        glue = {"stepdefinitions", "apphooks"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }
)

public class TestRunner {

}
