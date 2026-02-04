package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FrameworkConstants;

public class ExaminerExamSchdulePage extends BasePage {

	private @FindBy(id = "idScheDate") WebElement examDate;

	private @FindBy(css  = "[istoday='1']") WebElement chooseDate; /// select date 5 of current month
																						/// and current year

	private @FindBy(id = "idModuleID") WebElement ExamModule;

	private @FindBy(id = "idTotQ") WebElement numberOfQuestion;

	private @FindBy(id = "idDuration") WebElement timeDuration;

	private @FindBy(id = "txtPassingMark") WebElement passingMarks;

	private @FindBy(id = "rdExamStatusActive") WebElement statusYes;

	private @FindBy(id = "rdExamStatusInactive") WebElement statusNo;

	private @FindBy(id = "rdExamResultYes") WebElement showResultYes;

	private @FindBy(id = "rdExamResultNo") WebElement showResultNo;

	private @FindBy(xpath = "(//*[@class=\"button\"])[1]") WebElement schedule;
	
	private @FindBy(id = "msgDiv") WebElement examScheduleMessage;

	

	public ExaminerExamSchdulePage() {
//		System.out.println("Driver in LoginPage = " + getDriver());
		PageFactory.initElements(getDriver(), this);
	}

	public void schduleExamStausYesShowResultYes() {
		click(examDate);
		click(chooseDate);
		selectByIndex(ExamModule, 1);
		type(numberOfQuestion, FrameworkConstants.TOTAL_QUESTIONS);
		type(timeDuration, FrameworkConstants.EXAM_DURATION);
		type(passingMarks, FrameworkConstants.PASSING_MARKS);
		click(statusYes); 
		click(showResultYes);
		click(schedule);
	}

	public void schduleExamStausNoShowResultNo() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, FrameworkConstants.DEFAULT_EXAM_MODULE);
		type(numberOfQuestion, FrameworkConstants.TOTAL_QUESTIONS);
		type(timeDuration, FrameworkConstants.EXAM_DURATION);
		type(passingMarks, FrameworkConstants.PASSING_MARKS);
		click(statusNo);
		click(showResultNo);
		click(schedule);

	}

	public void schduleExamStausYesShowResultNo() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, FrameworkConstants.DEFAULT_EXAM_MODULE);
		type(numberOfQuestion, FrameworkConstants.TOTAL_QUESTIONS);
		type(timeDuration, FrameworkConstants.EXAM_DURATION);
		type(passingMarks, FrameworkConstants.PASSING_MARKS);
		click(statusYes);
		click(showResultNo);
		click(schedule);

	}

	public void schduleExamStausNoShowResultYes() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, FrameworkConstants.DEFAULT_EXAM_MODULE);
		type(numberOfQuestion, FrameworkConstants.TOTAL_QUESTIONS);
		type(timeDuration, FrameworkConstants.EXAM_DURATION);
		type(passingMarks, FrameworkConstants.PASSING_MARKS);
		click(statusNo);
		click(showResultYes);
		click(schedule);

	}

	
	public boolean verifyExamScheduleessage() {
		try {
			isDisplayed(examScheduleMessage);
			Thread.sleep(1000);
			System.out.println(getText(examScheduleMessage));
			return true;
		} catch (Exception e) {
			System.out.println(getText(examScheduleMessage));
			return false;
		}
	}
	
}
