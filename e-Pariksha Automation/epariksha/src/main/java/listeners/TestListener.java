package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener  implements ITestListener{

	
	private ExtentReports extent = ExtentReportManager.getExtentReports();
	private ExtentTest test;

	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
		
		String testName = result.getMethod().getMethodName();
		
		test = extent.createTest(testName);
		test.info("Test Stared : "+ testName);
		
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		
		
		
	}
	
	
	
}
