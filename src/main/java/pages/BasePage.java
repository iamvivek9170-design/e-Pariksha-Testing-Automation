package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;
import utils.LoggerUtil;
import utils.WaitUtils;

import org.apache.logging.log4j.Logger;
//import utils.LoggerUtil;

public class BasePage {

	protected WebDriver getDriver() {
		return DriverFactory.getDriver();
	}

	private static final Logger log = LoggerUtil.getLogger(BasePage.class);

	public void click(WebElement element) {
		try {
			log.info("Clicking on element ");
			WaitUtils.waitForClickable(getDriver(), element).click();
			log.info("Click successful");
		} catch (Exception e) {
			log.error("Click failed: {}", e.getMessage());
			throw e;
		}
	}

	public void type(WebElement element, String text) {
		try {
			log.info("Clicking on element ");
			WaitUtils.waitForVisibility(getDriver(), element).sendKeys(text);
			log.info("Typing successful");
		} catch (Exception e) {
			log.error("Typing failed: {}", e.getMessage());
			throw e;
		}
	}

	public String getText(WebElement element) {
		return WaitUtils.waitForVisibility(getDriver(), element).getText();
	}

	public boolean isDisplayed(WebElement element) {
	    try {
	        return element.isDisplayed();   
	    } catch (Exception e) {
	        return false;                  
	    }
	}


	public void clear(WebElement element) {
		WaitUtils.waitForVisibility(getDriver(), element).clear();
	}

	public void openUrl(String url) {
		try {
			log.info("Navigating to URL: {}", url);
			getDriver().get(url);
			log.info("Navigation successful");
		} catch (Exception e) {
			log.error("Navigation failed: {}", e.getMessage());
			throw e;
		}
	}

	////////////////////////
	public void selectByVisibleText(WebElement element, String partialText) {

		WebElement dropdown = WaitUtils.waitForVisibility(getDriver(), element);

		Select select = new Select(dropdown);

		boolean found = false;

		for (WebElement option : select.getOptions()) {

			String optionText = option.getText().trim();

			if (optionText.contains(partialText.trim())) {

				select.selectByVisibleText(optionText);

				found = true;
				break;
			}
		}

		if (!found) {
			throw new RuntimeException("Dropdown option not found containing text: " + partialText);
		}
	}

	public void selectByIndex(WebElement element, int index) {

		WebElement dropdown = WaitUtils.waitForVisibility(getDriver(), element);

		Select select = new Select(dropdown);

		select.selectByIndex(index);
	}


	
	
}

