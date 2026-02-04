package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ConfigReader;

public class ExtentReportManager {
	
	
    private static ExtentReports extent;
	
	public static ExtentReports getExtentReports() {
		
		if (extent == null) {
           
			String reportPath = "test-output/ExtentReport.html";

			ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);
			
			sparkReporter.config().setReportName("e-Pariksha Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Results");
            sparkReporter.config().setTheme(Theme.STANDARD);
             

		
            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);
            
            
            extent.setSystemInfo("Project Name", "e-Pariksha Automation Framework");
            extent.setSystemInfo("Tester", "Vivek Tiwari");
            extent.setSystemInfo("Browser", ConfigReader.getPropertyValue("browser"));
            extent.setSystemInfo("Environment", "CDAC Campus Server");
            extent.setSystemInfo("Framework", "Selenium + TestNG + POM");
		
		}
		 
		return extent;
		
	}
	
}
