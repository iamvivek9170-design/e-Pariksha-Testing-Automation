package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminResultPage extends BasePage {

	private @FindBy(id = "selectCourse") WebElement selectCourse;

	private @FindBy(id = "selectModule") WebElement selectModule;

	private @FindBy(id = "selectExamDate") WebElement selectDate;

	private @FindBy(xpath = "(//*[@class=\"lblstyle\"])[5]") WebElement subjectName;

	public AdminResultPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void showResultOfStudent() {
		selectByIndex(selectCourse, 1);
		selectByIndex(selectModule, 1);
		selectByIndex(selectDate, 1);
	}

	public boolean verifyResultVisibleToAdmin() {
		try {
			isDisplayed(subjectName);
			Thread.sleep(1000);
			System.out.println("Result is Visible for " + getText(subjectName));

			return true;
		} catch (Exception e) {
			System.out.println(getText(subjectName));
			return false;
		}
	}

}
