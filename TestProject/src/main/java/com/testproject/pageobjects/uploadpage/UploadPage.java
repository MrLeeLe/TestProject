package com.testproject.pageobjects.uploadpage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testproject.base.CommonPage;

public class UploadPage extends CommonPage {

	// LIST OF ELEMENTS ON UPLOAD PAGE---------------------------------------
	@FindBy(how = How.ID, using = "uploadfile_0")
	WebElement btnChooseFile;
	@FindBy(how = How.XPATH, using = "//b[contains(text(), 'Select file to send')]")
	WebElement lblFileSizeHint;
	@FindBy(how = How.ID, using = "terms")
	WebElement chkAcceptTermAndService;
	@FindBy(how = How.XPATH, using = "//a[@href='rules.php']") 
	WebElement lnkTermAndService;
	@FindBy(how = How.ID, using = "submitbutton")
	WebElement btnSubmitFile;
	@FindBy(how = How.ID, using = "res")
	WebElement msgResponseMessage;
	
	//a[@href='rules.php']

	// CONSTRUCTOR
	public UploadPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// LIST OF PAGE ACTIONS---------------------------------------------------
	public void uploadFileAndAcceptTermAndService(String filename) {
		String fileLocation = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator 
				+ "resources" + File.separator + "testdata" + File.separator + filename;
		try {
			sendKeys(btnChooseFile, fileLocation);
			chkAcceptTermAndService.click();
			btnSubmitFile.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadFileWithoutAcceptTermAndService(String filename) {
		String fileLocation = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator 
				+ "resources" + File.separator + "testdata" + File.separator + filename;
		try {
			sendKeys(btnChooseFile, fileLocation);
			btnSubmitFile.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void uploadNoFile() {
		try {
			chkAcceptTermAndService.click();
			btnSubmitFile.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// LIST OF VALIDATIONS----------------------------------------------------
	public boolean isChooseFileFieldDisplay() {
		if (isDisplay(btnChooseFile)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFileSizeHintDisplay() {
		if (isDisplay(lblFileSizeHint)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAcceptTermAndServiceCheckboxDisplay() {
		if (isDisplay(chkAcceptTermAndService)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isButtonSubmitFiledisplay() {
		if (isDisplay(btnSubmitFile)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isTermAndServiceHyperlinkDisplay() {
		if (isDisplay(lnkTermAndService)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFileUploadSuccess() {
		waitForLoading(msgResponseMessage);
		if (msgResponseMessage.getText().contains("has been successfully uploaded.")) {
			System.out.println(msgResponseMessage.getText());
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isFailToUploadFile() {
		waitForLoading(msgResponseMessage);
		if (!msgResponseMessage.getText().contains("has been successfully uploaded.")) {
			return true;
		} else {
			return false;
		}
	}
}
