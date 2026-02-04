package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.DriverFactory;
import utils.LoggerUtil;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static final Logger log = LoggerUtil.getLogger(TestListener.class);

    private static ExtentReports extent = ExtentReportManager.getExtentReports();

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override 
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        log.info("STARTING TEST: " + testName);
        log.info("========================================");

        ExtentTest test = extent.createTest(testName);

        extentTest.set(test);

        String className = result.getTestClass().getName();

        if (className.contains("smoke")) {
            extentTest.get().assignCategory("Smoke Tests");
        }
        else if (className.contains("regression")) {
            extentTest.get().assignCategory("Regression Tests");
        }
        else if (className.contains("sanity")) {
            extentTest.get().assignCategory("Sanity Tests");
        }

        extentTest.get().info("Test Started : " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        extentTest.get().pass("✅ Test Passed Successfully : " + testName);

        log.info("TEST PASS : " + testName);
        log.info("========================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        log.error("TEST FAIL : " + testName);
        log.error("========================================");

        if (extentTest.get() == null) {

            ExtentTest test = extent.createTest(testName);
            extentTest.set(test);
        }

        extentTest.get().fail(result.getThrowable());

        try {
            WebDriver driver = DriverFactory.getDriver();

            String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);

            extentTest.get().fail(
                    "Screenshot Attached",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
            );

            log.info("Screenshot Attached: " + screenshotPath);

        }
        catch (Exception e) {

            extentTest.get().fail("Screenshot Capture Failed: " + e.getMessage());
            log.error("Screenshot Capture Failed: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        if (extent != null) {
            extent.flush();
        }

        extentTest.remove();

        log.info("========================================");
        log.info("Test Execution Finished Successfully");
    }
}
