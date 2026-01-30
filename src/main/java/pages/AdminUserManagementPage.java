package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public AdminUserManagementPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void addNewUser() {
		click(newUser);
		type(firstName, "Atul");
		type(middleName, " ");
		type(lastName, "Yadav");
		click(dob);
		click(chooseDob);
		type(eMailId, "123fgf@gg");
		type(contactNo, "1234567891");
		click(gender);
		click(save);
	}

//	public boolean verifyNewUserAdded() {
//		return false;
//	} 

	public void editUserDeatil() {
//		click(selectExistingUser);
		try {
			selectByVisibleText(selectExistingUser, "Vivek tiwari");
		} catch (Exception e) {
			throw new RuntimeException("Selected user doesn't exist " + e.getMessage());
		}
		click(editExistinngUserdetail);
		clear(lastName);
		type(lastName, "Tiwari");
		click(update);
	}

//	public boolean verifyeditUserDeatil() {
//		return false;
//	}

	public void resetPasswordOfUser() {
		try {
			selectByVisibleText(selectExistingUser, "Vivek tiwari");
		} catch (Exception e) {
			throw new RuntimeException("Selected user doesn't exist " + e.getMessage());
		}
		click(resetPassword);
	}

//	public boolean verifyresetPasswordOfUser() {
//	return false;
//}

}
