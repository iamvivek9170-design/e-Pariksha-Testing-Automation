package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FrameworkConstants;

public class AdminCoursesPage extends BasePage {

	private @FindBy(id = "test") WebElement addcourseButton;

	private @FindBy(id = "txtCourseName") WebElement courseName;

	private @FindBy(id = "txtCourseShortName") WebElement courseAbbrevation;

	private @FindBy(id = "txtCourseDate") WebElement validity;

	private @FindBy(xpath = "//div[@istoday=\"1\"]/following-sibling::div[20]") WebElement choseValidityDate;

	private @FindBy(xpath = "//a[@onclick=\"javascript:AddCourses()\"]") WebElement addNewcourse;

	private @FindBy(xpath = "//a[@onclick=\"javascript:AddModule()\"]") WebElement addNewModule;

	private @FindBy(id = "linkAddUser") WebElement addNewUserTocourse;

	private @FindBy(partialLinkText = "[X]") WebElement cancel;

	private @FindBy(id = "lblDisplayMessage") WebElement addcourseverificationmessage;
	// Edit Existing course
	private @FindBy(xpath = "//*[text()='AF2']") WebElement selectExistingCourse;

	private @FindBy(partialLinkText = "Edit") WebElement editcourseButton;

	private @FindBy(partialLinkText = "Update") WebElement UpdatecourseButton;
	
	private @FindBy(id = "drpUsers") WebElement assignExaminer;

	private @FindBy(xpath = "//*[text()='Add Module']") WebElement addModule;

	private @FindBy(id = "txtModuleName") WebElement moduleName;

	private @FindBy(id = "lblDisplayModuleMessage") WebElement newModuleaddedMessage;

	private @FindBy(xpath = "//*[text()=\"Add Module\"]") WebElement addExistingModule;

	private @FindBy(id = "drpCourses") WebElement selectCourseToaddexistingModule;// select all module method add

	public AdminCoursesPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void addnewCourse() {
		click(addcourseButton);
		type(courseName, FrameworkConstants.NEW_COURSE_NAME);
		type(courseAbbrevation, FrameworkConstants.NEW_COURSE_ABBREVATION);
		click(validity);
		click(choseValidityDate);
		click(addNewcourse);
	}

	public boolean verifyaddnewCourse() {
		try {
			isDisplayed(addcourseverificationmessage);
			Thread.sleep(1000);
			System.out.println(getText(addcourseverificationmessage));

			return true;
		} catch (Exception e) {
			System.out.println(getText(addcourseverificationmessage));
			return false;
		}
	}

	//////
	public void addingModuleToExstingCourse() {
		click(selectExistingCourse);
		click(addModule);
		type(moduleName, FrameworkConstants.NEW_MODULE_NAME);
		click(addNewModule);

		System.out.println(getText(newModuleaddedMessage));

	}

	public boolean verfiynewModuleAdded() {
		try {
			isDisplayed(newModuleaddedMessage);
			Thread.sleep(1000);
			System.out.println(getText(newModuleaddedMessage));

			return true;
		} catch (Exception e) {
			System.out.println(getText(newModuleaddedMessage));
			return false;
		}
	}

	public void updateingDeatilOfCourse() {
		click(selectExistingCourse);
		click(editcourseButton);
		click(UpdatecourseButton);

	}

	public void assignUserToCourse() {
		selectByVisibleText(assignExaminer, "Vive");
		click(addNewUserTocourse);
	}

	public void cancel() {
		click(cancel);
	}

}
