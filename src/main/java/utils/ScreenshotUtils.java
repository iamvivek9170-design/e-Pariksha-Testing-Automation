package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        try {

            // ✅ Correct folder path (framework locked rule)
            String folderPath = "test-output/screenshots/";

            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // ✅ Correct screenshot name
            String screenshotName =
                    testName + "_" + System.currentTimeMillis() + ".png";

            // ✅ Final full screenshot path
            String screenshotPath = folderPath + screenshotName;

            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File destFile = new File(screenshotPath);

            FileUtils.copyFile(scrFile, destFile);

            // ✅ Return relative path for Extent Report
            return "screenshots/" + screenshotName;

        } catch (IOException e) {
            throw new RuntimeException("Screenshot capture failed", e);
        }
    }
}
