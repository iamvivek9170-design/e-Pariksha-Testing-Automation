package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class DriverFactory {

    private static WebDriver driver;

    public WebDriver initDriver() {

        if (driver == null) {

            String browser = ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            } else if (browser.equalsIgnoreCase("edge")) {

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            } else if (browser.equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else {

                throw new RuntimeException("Invalid browser name: " + browser);
            }

            driver.manage().window().maximize();

            int timeout = ConfigReader.getTimeout();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
        }

        return driver;
    }

    public void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }    
     
    }
    public  WebDriver getDriver() {
    	
    	
    	
		return driver;
  	  
    }
}
