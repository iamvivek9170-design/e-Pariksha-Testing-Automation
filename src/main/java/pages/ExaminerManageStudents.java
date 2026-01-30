package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;

public class ExaminerManageStudents extends BasePage{

// Student Data
private @FindBy(partialLinkText = "Data") WebElement studuentData ;

private @FindBy(partialLinkText  = "[X]") WebElement cancel;

private @FindBy(name = "txtUploadFile") WebElement chooseFile;

private @FindBy(name = "btnSubmit") WebElement upload;

private @FindBy(name = "btnCancel") WebElement reset;


public ExaminerManageStudents() {
	PageFactory.initElements(getDriver(), this);
}

// EditSudentData/ChnagePassword
private @FindBy(partialLinkText = "Student/Change") WebElement editStudent ;

private @FindBy(id = "chkSelectStudentAll") WebElement SelectStudentAll;

private @FindBy(id = "btnBlockStud") WebElement block;

private @FindBy(id = "btnUnblockStud") WebElement unblock;

//private @FindBy(partialLinkText  = "[X]") WebElement cancel;


public void uploadStudentData() {
	click(studuentData);
	click(chooseFile); 
	try {
		type(upload, ConfigReader.getPropertyValue("uploadStudentfile"));

	} catch (Exception e) {

		throw new RuntimeException("Use specific xls format to upload student data. Error: " + e.getMessage());	}
	
}

public void editStudent() {
	click(editStudent);
	click(SelectStudentAll);
	click(block);
	click(SelectStudentAll);
	click(unblock);
	click(cancel);
}


//public void listOfBlock() {
//click(m);
//}


}
