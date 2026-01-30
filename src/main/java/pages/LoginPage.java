package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;

public class LoginPage extends BasePage {

	private @FindBy(name = "txtUserId") WebElement userId;

	private @FindBy(name = "txtPassword") WebElement password;

	private @FindBy(name = "Image6") WebElement loginButton;

	private @FindBy(className = "pageheader") WebElement studentDashboard;

	private @FindBy(className = "pageheader") WebElement coordinatorDashboard;

	private @FindBy(className = "pageheader") WebElement adminDashboard; 

	private @FindBy(css = "[title='Logout']") WebElement logoutButton;

	private @FindBy(xpath = "(//*[@class='lblstyle'])[2]") WebElement loginPage;

	private @FindBy(id = "lblLogin") WebElement loginFailer;

	public LoginPage() {
//		System.out.println("Driver in LoginPage = " + getDriver());
		PageFactory.initElements(getDriver(), this);
	} 

	public void loginMethod(String userid, String pass) {

		type(userId, userid);
		type(password, pass);
		click(loginButton);
	}

	public void logoutMethod() {
		click(logoutButton);
	}

	public boolean verifyStudentDashboard() {
		try {
			System.out.println("You are on "+getText(studentDashboard) );
			return isDisplayed(studentDashboard);

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyAdminDashboard() {

		try {
			System.out.println("You are on "+getText(adminDashboard) );
			return isDisplayed(adminDashboard);

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyCoordinatorDashboard() {
		try {
			System.out.println("You are on "+getText(coordinatorDashboard) );
			return isDisplayed(coordinatorDashboard);

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verifyLoginPage() {
		return isDisplayed(loginPage);
	}

	public boolean verifyLoginFailer() {
		System.out.println("Error Message on login failer : " + getText(loginFailer));
		return isDisplayed(loginFailer);
	}
	 
	
	public void coordinatorlogin() {
		type(userId,ConfigReader.getPropertyValue("coordinatorUserId"));
		type(password, ConfigReader.getPropertyValue("coordinatorPassword"));
		click(loginButton); 
	}
	 
	public void adminlogin() { 
		type(userId,ConfigReader.getPropertyValue("adminUserId"));
		type(password, ConfigReader.getPropertyValue("adminPassword"));
		click(loginButton);
	}

	public void studentlogin() {  
		type(userId,ConfigReader.getPropertyValue("studentUserId"));
		type(password, ConfigReader.getPropertyValue("studentPassword"));
		click(loginButton);
	}

	
} 
