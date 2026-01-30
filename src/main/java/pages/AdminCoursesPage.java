package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCoursesPage extends BasePage{

	private @FindBy (id = "test") WebElement addcourseButton;

	private @FindBy (id = "txtCourseName") WebElement courseName;

	private @FindBy (id = "txtCourseShortName") WebElement courseAbbrevation;

	private @FindBy (id = "txtCourseShortName") WebElement validity;
	private @FindBy (className = "dayNormalToday") WebElement choseValidityDate;

	
	private @FindBy (partialLinkText = "Add") WebElement addNew;

	private @FindBy (partialLinkText = "[X]") WebElement cancel;

	// Edit Existing course 
	private @FindBy (xpath = "//*[@id=\"divCourseList\"]/div[1]") WebElement selectExistingCourse;
	
	private @FindBy (partialLinkText = "Edit") WebElement editcourseButton;
//
	private @FindBy (partialLinkText = "Update") WebElement UpdatecourseButton;

	private @FindBy (xpath  = "//*[text()='Add existing '] ") WebElement addModule;
	
	private @FindBy (id = "txtModuleName") WebElement moduleName;

	//
	private @FindBy (xpath = "//*[text()=\"Add Module\"]") WebElement addExistingModule;
	
	private @FindBy (id = "drpCourses") WebElement selectCourseToaddexistingModule;// select all module method add

	
	public AdminCoursesPage() {
		PageFactory.initElements(getDriver(), this);
	}

}
