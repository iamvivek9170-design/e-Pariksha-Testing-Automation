package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FrameworkConstants;

public class ExaminerManageStudents extends BasePage {

// Student Data
	private @FindBy(partialLinkText = "Data") WebElement studuentData;

	private @FindBy(partialLinkText = "[X]") WebElement cancel;

	private @FindBy(name = "txtUploadFile") WebElement chooseFile;

	private @FindBy(name = "btnSubmit") WebElement upload;

	private @FindBy(name = "btnCancel") WebElement reset;

	public ExaminerManageStudents() {
		PageFactory.initElements(getDriver(), this);
	}

// EditSudentData/ChnagePassword
	private @FindBy(partialLinkText = "Student/Change") WebElement editStudent;

	private @FindBy(id = "chkSelectStudentAll") WebElement SelectStudentAll;

	private @FindBy(id = "btnBlockStud") WebElement block;

	private @FindBy(id = "btnUnblockStud") WebElement unblock;

	private @FindBy(id = "msgDiv") WebElement fileUploadMessage;

	private @FindBy(id = "labelMessage") WebElement blockUnblockMessage;

	public void uploadStudentData() {
		click(studuentData);
		try {
			type(chooseFile, FrameworkConstants.STUDENT_DATA_VALID_FILE);
		} catch (Exception e) {
			throw new RuntimeException("Use specific xls format to upload student data. Error: " + e.getMessage());
		}
		click(upload);
	}

	public void uploadStudentinvalidData() {
		click(studuentData);
		try {
			type(chooseFile, FrameworkConstants.STUDENT_DATA_INVALID_FILE);
		} catch (Exception e) {
			throw new RuntimeException("Use specific xls format to upload student data. Error: " + e.getMessage());
		}
		click(upload);
	}

	public void blockStudent() {
		click(editStudent);
		click(SelectStudentAll);
		click(block);
		System.out.println(getText(blockUnblockMessage));
		click(cancel);

	}

	public void unBlockStudent() {
		click(editStudent);
//	click(SelectStudentAll);
//	click(block);
		click(SelectStudentAll);
		click(unblock);
		System.out.println(getText(blockUnblockMessage));
		click(cancel);
	}

	public boolean verifyblockUnblockmessage() {
		try {
			isDisplayed(blockUnblockMessage);
			Thread.sleep(2000);
			System.out.println(getText(blockUnblockMessage));

			return true;
		} catch (Exception e) {
			System.out.println(getText(blockUnblockMessage));
			return false;
		}

	}

	public void cancel() {
		click(cancel);
	}

	public boolean verifyfileuploadMessage() {
		try {
			isDisplayed(fileUploadMessage);
			Thread.sleep(1000);
			System.out.println(getText(fileUploadMessage));

			return true;
		} catch (Exception e) {
			System.out.println(getText(fileUploadMessage));
			return false;
		}
	}

}
