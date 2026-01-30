package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;
import utils.WaitUtils;

public class BasePage {

	protected WebDriver getDriver() {
		return DriverFactory.getDriver();
	}
 


	
	 
	public void click(WebElement element) {
		WaitUtils.waitForClickable(getDriver(), element).click();
	}
 
	public void type(WebElement element, String text) {
		WaitUtils.waitForVisibility(getDriver(), element).sendKeys(text);
	}

	public String getText(WebElement element) {
		return WaitUtils.waitForVisibility(getDriver(), element).getText();
	}

	public boolean isDisplayed(WebElement element) {

		return WaitUtils.waitForVisibility(getDriver(), element).isDisplayed();
	}
 
	public void clear(WebElement element) {
		WaitUtils.waitForVisibility(getDriver(), element).clear();
	}

	public void openUrl(String url) {
		getDriver().get(url);
	}

	public void selectByVisibleText(WebElement element, String text) {

	    Select select = new Select(WaitUtils.waitForVisibility(getDriver(), element));
	    select.selectByVisibleText(text);
	}
	
}
