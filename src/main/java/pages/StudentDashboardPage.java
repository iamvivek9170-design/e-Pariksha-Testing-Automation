package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.DriverFactory;
import utils.ConfigReader;

public class StudentDashboardPage extends BasePage {

	private @FindBy(css = "[pagenumber='0pg']") WebElement Module1;

	private @FindBy(css = "[pagenumber='1pg']") WebElement Module2;

	private @FindBy(id = "time") WebElement timer;

	private @FindBy(id = "link1") WebElement questionNumber;

	private @FindBy(id = "Option1") WebElement Option1;

	private @FindBy(id = "Option2") WebElement Option2;

	private @FindBy(id = "Option3") WebElement Option3;

	private @FindBy(id = "Option4") WebElement Option4;

	private @FindBy(name = "btnNext") WebElement nextButton;

	private @FindBy(name = "btnPrevious") WebElement previousButton;

	private @FindBy(name = "btnEnd") WebElement endExam;
	
	private @FindBy(className = "pageheader") WebElement resultStudent;

	public void stratExam() {
		
		int i = 1;
		int totalQuestion = Integer.parseInt(ConfigReader.getPropertyValue("totalQuestion"));
		click(Module1);
		while (i <= totalQuestion) {
			click(Option1);
			if(i<totalQuestion) {
			click(nextButton);
			}
			i++;
		}
		click(endExam);
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}

	public boolean verifyExamStart() {
		try {
			isDisplayed(timer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyStudentResult() {
		return isDisplayed(resultStudent);	
	}

	
	
	
}
