package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {


public static String captureScreenshot( WebDriver driver, String testName)  {

	
	
	try {
		
	
	String folderPath = "test-output/screenshots/";
	
	File folder = new File(folderPath);
	
	if(!folder.exists()) {
		folder.mkdirs();
	}
	
	String screenshotPath = folderPath + folder + "_" + System.currentTimeMillis() + ".png";

	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	File destFile = new File(screenshotPath);
	
	FileUtils.copyFile(scrFile, destFile);

	 
	
	return screenshotPath;
	}
	
	catch(IOException e) {
		   throw new RuntimeException("Screenshot capture failed", e);
		}
	
	
}

}
