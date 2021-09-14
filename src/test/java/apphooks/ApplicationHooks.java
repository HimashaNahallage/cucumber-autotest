package apphooks;

import factory.DriverFactory;
import util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

//Feature of hooks -> @BeforeThreads and @AfterThreads run before and after every Scenario
//Hooks responsibility to launch the browser otherwise have to write same step again and again in featurefile
public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    //Above are private coz specific to this class only
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.initialize_properties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        //driverFactory =  driverFactory.initialize_driver(browserName);
        driver = driverFactory.initialize_driver(browserName);
    }

    //order=1 will be execute first
    @After(order = 0)
    public void quitBrowser() {
        driver.quit(); //driverFactory =  driverFactory.initialize_driver(browserName); -> will give null.driver()
    }

    //New learn-Scenario object concept
    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);//Convert the driver into typecaste to get screenshot Base64 /byte
            scenario.attach(sourcePath, "image/png", screenshotName); //calling the attach api
        }
    }
}
