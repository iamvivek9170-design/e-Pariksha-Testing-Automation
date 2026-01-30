package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	
    private static ExtentReports extent;
	
	public static ExtentReports getExtentReports() {
		
		if (extent == null) {
           
			String reportPath = "test-output/ExtentReport.html";

			ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportPath);
			
			sparkReporter.config().setReportName("e-Pariksha Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Results");

		
            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);
		
		}
		 
		return extent;
		
	}
	
}
