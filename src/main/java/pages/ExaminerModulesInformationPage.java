package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FrameworkConstants;

public class ExaminerModulesInformationPage extends BasePage{
  
	@FindBy(id = "23110") 
	private WebElement QuesRepository;

	@FindBy(partialLinkText  = "Upload ")
	private WebElement uploadQuestion;

	@FindBy(xpath = "//input[@id=\"txtUploadFile\"]")
	private WebElement zipUploadField;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileInput;

	@FindBy(xpath = "//input[@name=\"btnUpload\"]")
	private WebElement uploadButton;

	@FindBy(xpath = "//input[@id=\"zipPassword\"]")
	private WebElement filePass;

	@FindBy(xpath = "//input[@id=\"passwordSubmitArea\"]")
	private WebElement submitZipFile;
	
    @FindBy(xpath = "//label[@id=\"lblmessages\"]") 
    private WebElement uploadSuccessMsg;
    
    @FindBy (xpath = "//input[@value='Yes']") WebElement uploadagainmessage;

    
	public ExaminerModulesInformationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void questionUpload() {
		click(QuesRepository);
		if(isDisplayed(uploadagainmessage)) {
			click(uploadagainmessage);
		}

		click(uploadQuestion);
		type(fileInput, FrameworkConstants.QUESTION_BULK_FILE);
		click(uploadButton);
		type(filePass, "Asdf@1234");
		click(submitZipFile);
		System.out.println(getText(uploadSuccessMsg));

	}
	
	
}
