package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FrameworkConstants;
import utils.WaitUtils;

public class AdminUserManagementPage extends BasePage {

	// Under User page
	private @FindBy(partialLinkText = "User") WebElement newUser;

	private @FindBy(id = "idBtnResetPass") WebElement resetPassword;

	private @FindBy(id = "idTxtFName") WebElement firstName;

	private @FindBy(id = "idTxtMName") WebElement middleName;

	private @FindBy(id = "idTxtLname") WebElement lastName;

	private @FindBy(id = "idTxtDOB") WebElement dob;
	private @FindBy(className = "dayNormalToday") WebElement chooseDob;

	private @FindBy(id = "idTxtEmail") WebElement eMailId;

	private @FindBy(id = "idTxtContactNo") WebElement contactNo;

	private @FindBy(id = "idGenderM") WebElement gender;

//	private @FindBy () WebElement forCourse;

	private @FindBy(css = "[value='Save']") WebElement save;

	private @FindBy(id = "btnCancel") WebElement cancel;

//	private @FindBy () WebElement successMessage; ///    use j script to find the web element of this message  

	private @FindBy(id = "CCID") WebElement selectExistingUser;

	private @FindBy(id = "idBtnEdit") WebElement editExistinngUserdetail;

	private @FindBy(name = "btnUpdate") WebElement update;

	private @FindBy(id = "IdSeMsg") WebElement userCreatedMessage;

	private @FindBy(id = "tokill") WebElement PasswordResetMessage;

	public AdminUserManagementPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void addNewUser() {
		click(newUser);
		type(firstName, FrameworkConstants.NEW_USER_FIRST_NAME);
		type(middleName, " ");
		type(lastName, FrameworkConstants.NEW_USER_LAST_NAME);
		click(dob);
		click(chooseDob);
		type(eMailId, FrameworkConstants.NEW_USER_EMAIL);
		type(contactNo, FrameworkConstants.NEW_USER_CONTACT);
		click(gender);
		click(save);
	}

	public void editUserDeatil() {

		selectByVisibleText(selectExistingUser, FrameworkConstants.EXISTING_USER_NAME);

		WaitUtils.waitForClickable(getDriver(), editExistinngUserdetail);

		click(editExistinngUserdetail);

		clear(lastName);
		type(lastName, FrameworkConstants.UPDATED_LAST_NAME);

		click(update);
	}

	public boolean verifyMessage() {
		try {
			System.out.println(getText(userCreatedMessage));
			isDisplayed(userCreatedMessage);
			return true;
		} catch (Exception e) {
			System.out.println(getText(userCreatedMessage));
			return false;
		}
	}

	public void resetPasswordOfUser() {
		try {
			selectByVisibleText(selectExistingUser, FrameworkConstants.EXISTING_USER_NAME);
		} catch (Exception e) {
			throw new RuntimeException("Selected user doesn't exist " + e.getMessage());
		}
		click(resetPassword);
	}

	public boolean verifyresetPasswordOfUser() {
		try {
			isDisplayed(PasswordResetMessage);
			Thread.sleep(1000);
			System.out.println(getText(PasswordResetMessage));

			return true;
		} catch (Exception e) {
			System.out.println(getText(PasswordResetMessage));
			return false;
		}
	}

}
