package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage extends BasePage {

	private @FindBy(id = "Image5") WebElement homes;

	private @FindBy(id = "Image6") WebElement user;

	private @FindBy(id = "Image7") WebElement course;

	private @FindBy(id = "Image8") WebElement result;

	private @FindBy(id = "Image9") WebElement reports;

	private @FindBy(id = "Image9") WebElement profile;

	private @FindBy(partialLinkText = "Switch Course") WebElement switchCourse;
	
	private @FindBy (xpath = "(//td[@align='left']//a[contains(@onclick,'switchToSelectedCourse')])[46]\r\n") WebElement selectCorse;

	public AdminDashboardPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
 	
	public void home() {
		click(homes);
	}

	public void users() {
		click(user);
	}

	public void courses() {
		click(course);
	}

	public void results() {
		click(result);
	}

	public void reports() {
		click(reports);
	}

	public void profile() {
		click(profile);
	}

	public void switchToUser() {
		click(switchCourse);
		click(selectCorse);
	}
	
}
