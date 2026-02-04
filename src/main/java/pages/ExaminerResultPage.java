package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExaminerResultPage extends BasePage {

	private @FindBy(id = "selectModule") WebElement selectModule;

	private @FindBy(id = "selectExamDate") WebElement selectExamDatw;

	private @FindBy(xpath = "(//*[@class=\"lblstyle\"])[4]") WebElement SubjectName;

	private @FindBy(xpath = "(//*[@class=\"lblstyle\"])[6]") WebElement SubjectDate;

	public ExaminerResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void seeResultOfStudent() {
		selectByIndex(selectModule, 1);
		selectByIndex(selectExamDatw, 1);
	}
	
	public boolean verifyResultVisible() {
		try {
			isDisplayed(SubjectName);
			Thread.sleep(1000);
			System.out.println(getText(SubjectName)+" exam schedule on  "+getText(SubjectDate));

			return true;
		} catch (Exception e) {
			System.out.println(getText(SubjectName));
			return false;
		}
	}

}
