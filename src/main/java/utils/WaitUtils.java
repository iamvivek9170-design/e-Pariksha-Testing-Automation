package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static WebDriverWait getWait(WebDriver driver) {

	    return new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getPropertyValue("timeout"))));
	}
 
      
	public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return getWait(driver).until(
                ExpectedConditions.visibilityOf(element)
        );
    }
	
	public static WebElement waitForClickable(WebDriver driver, WebElement element) {
        return getWait(driver).until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }
    
	public static boolean waitForInvisibility(WebDriver driver, WebElement element) {
        return getWait(driver)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean waitForTitleContains(WebDriver driver, String titleText) {
        return getWait(driver)
                .until(ExpectedConditions.titleContains(titleText));
    }
    
    
    
    
    
	
}
 