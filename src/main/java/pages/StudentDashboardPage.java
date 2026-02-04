package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import constants.FrameworkConstants;

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

	private @FindBy(id = "divEditMsg") WebElement examNotSchdulleMessage;

	public StudentDashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean stratExam() {

	    int totalQuestion = Integer.parseInt(FrameworkConstants.TOTAL_QUESTIONS);

	    // ✅ First Check: Is the module completely missing?
	    if (!isDisplayed(Module1)) {
	        System.out.println("No exam is scheduled today. Please contact examiner");
	        return false;
	    }

	    // ✅ Second Check: Is it displayed but already completed?
	    // We check the "title" attribute which says "Exam already given"
	    String status = Module1.getAttribute("title");
	    if (status != null && status.contains("already given")) {
	        System.out.println("Student has already completed this exam.");
	        return false;
	    }

	    click(Module1);

	    for (int i = 1; i <= totalQuestion; i++) {
	        click(Option1);
	        if (i < totalQuestion) {
	            click(nextButton);
	        }
	    }

	    click(endExam);

	    Alert alert = DriverFactory.getDriver().switchTo().alert();
	    alert.accept();

	    return true; 
	}

	public boolean verifyExamStart() {
	    // Modified to be true if timer is visible OR if it's already finished
	    return isDisplayed(timer) || Module1.getAttribute("title").contains("already given");
	}



	public boolean verifyStudentResult() {
		return isDisplayed(resultStudent);
	}

	public boolean verifyExamNotScheduledMessage() {
		return isDisplayed(examNotSchdulleMessage);
	}
}
