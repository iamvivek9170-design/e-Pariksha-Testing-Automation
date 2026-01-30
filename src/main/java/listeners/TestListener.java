package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.DriverFactory;
import utils.ScreenshotUtils;

public class TestListener  implements ITestListener{

	
	private ExtentReports extent = ExtentReportManager.getExtentReports();
	private ExtentTest test;

	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
		String testName = result.getMethod().getMethodName();
		
		test = extent.createTest(testName);
		test.info("Test Started : " + testName);
		
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		String testName = result.getMethod().getMethodName();
		
		test.pass("Test Passed successfully : "+testName);
		
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();

		test.fail(result.getThrowable());
	
		try {
		WebDriver driver = DriverFactory.getDriver();

		String screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);
		
		test.fail("Screenshot Attached",
	                MediaEntityBuilder
	                        .createScreenCaptureFromPath(screenshotPath)
	                        .build());		
		} catch (Exception e) {
	        test.fail("Screenshot capture failed: " + e.getMessage());
		}
		

		
		
	}
	
	@Override
	public void onFinish(ITestContext context) {

		if(extent != null) {
			extent.flush();
		}
	
	
	}
	
}
