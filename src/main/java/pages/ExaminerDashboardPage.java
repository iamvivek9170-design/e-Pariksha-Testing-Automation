package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ExaminerDashboardPage extends BasePage {

	private @FindBy(css = "[pagenumber='0pg']") WebElement courseInfo;

	private @FindBy(css = "[pagenumber='1pg']") WebElement moduleAndQuestion;

	private @FindBy(css = "[pagenumber='2pg']") WebElement manageStud;

	private @FindBy(css = "[pagenumber='3pg']") WebElement exam;

	private @FindBy(css = "[pagenumber='4pg']") WebElement Result;

	private @FindBy(css = "[pagenumber='5pg']") WebElement profile;
	
	private @FindBy (css = "[title=\"Home\"]") WebElement home;
	

	public ExaminerDashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	 
	public void courseInfo() {
		click(courseInfo);
	}

	public void moduleAndQuestion() {
		click(moduleAndQuestion);
	}

	public void manageStud() {
		click(manageStud);
	} 

	public void exam() {
		click(exam);
	}

	public void Result() {
		click(Result);
	}

	public void profile() {
		click(profile);
	}
	
	public void home() {
		click(home);
	}

}
