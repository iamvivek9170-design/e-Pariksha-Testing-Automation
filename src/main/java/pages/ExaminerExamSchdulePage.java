package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExaminerExamSchdulePage extends BasePage {

	private @FindBy(id = "idScheDate") WebElement examDate;

	private @FindBy(xpath = "(//*[@class=\"dayNormal\"])[6]") WebElement chooseDate; /// select date 5 of current month
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

	public ExaminerExamSchdulePage() {
//		System.out.println("Driver in LoginPage = " + getDriver());
		PageFactory.initElements(getDriver(), this);
	}

	public void schduleExamStausYesShowResultYes() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, "Module1");
		type(numberOfQuestion, "3");
		type(timeDuration, "2");
		type(passingMarks, "1");
		click(showResultYes); 
		click(showResultYes);
		click(schedule);
	}

	public void schduleExamStausNoShowResultNo() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, "Module1");
		click(numberOfQuestion);
		click(timeDuration);
		click(passingMarks);
		click(showResultNo);
		click(showResultNo);
		click(schedule);

	}

	public void schduleExamStausYesShowResultNo() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, "Module1");
		click(numberOfQuestion);
		click(timeDuration);
		click(passingMarks);
		click(showResultYes);
		click(showResultNo);
		click(schedule);

	}

	public void schduleExamStausNoShowResultYes() {
		click(examDate);
		click(chooseDate);
		selectByVisibleText(ExamModule, "Module1");
		click(numberOfQuestion);
		click(timeDuration);
		click(passingMarks);
		click(showResultNo);
		click(showResultYes);
		click(schedule);

	}

}
