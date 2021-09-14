package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;
    //Java8 feature ThreadLocal to run in parallel mode.
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /*This method is used to initialize the ThreadLocal driver on the basis of given browser
    @param browser
    @retrun*/
    public WebDriver initialize_driver(String browser){
        System.out.println("browser value is: " + browser);

        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else{
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

   /* This is used to get the driver with the ThreadLocal.
    @return */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
