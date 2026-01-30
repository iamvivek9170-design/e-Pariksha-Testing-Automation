package base;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

	DriverFactory driverFactory = new DriverFactory();


	@BeforeMethod
	public void setUp() {

		driverFactory.initDriver();
		DriverFactory.getDriver().get(ConfigReader.getPropertyValue("url"));

	}

	@AfterMethod
	public void tearDown() {

		driverFactory.quitDriver();
	}
 
}
 