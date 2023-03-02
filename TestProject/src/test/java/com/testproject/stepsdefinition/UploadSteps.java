package com.testproject.stepsdefinition;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;

import com.testproject.base.TestContext;
import com.testproject.pageobjects.uploadpage.*;
import com.testproject.systemconfigurations.GlobalParameters;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UploadSteps {
	
	TestContext testContext;
	WebDriver driver;
	UploadPage uploadPage;
	
	public UploadSteps(TestContext context) {
		testContext = context;
		driver = testContext.getDriverManager().getDriver();
		uploadPage = testContext.getPageObjectManager().getUploadPage();
	}

	@Given("User access to upload page")
	public void user_access_to_upload_page() {
	    try {
	    	driver.navigate().to(GlobalParameters.UPLOADFEATUREURL);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("Upload page displays properly")
	public void upload_page_displays_properly() {
	    assertTrue(uploadPage.isChooseFileFieldDisplay());
	    assertTrue(uploadPage.isFileSizeHintDisplay());
	    assertTrue(uploadPage.isAcceptTermAndServiceCheckboxDisplay());
	    assertTrue(uploadPage.isTermAndServiceHyperlinkDisplay());
	    assertTrue(uploadPage.isButtonSubmitFiledisplay());
	}
	
	@When("User upload no file")
	public void user_upload_no_file() {
	    uploadPage.uploadNoFile();
	}
	
	
	@When("User try to upload file {string} and accept terms of service")
	public void user_try_to_upload_file_and_accept_terms_of_service(String filename) {
	    uploadPage.uploadFileAndAcceptTermAndService(filename);
	}
	
	@When("User try to upload file {string} without accepting terms of service")
	public void user_try_to_upload_file_without_accept_term_of_service(String filename) {
	    uploadPage.uploadFileWithoutAcceptTermAndService(filename);
	}

	@Then("File is upload successfully")
	public void file_is_upload_successfully() {
		assertTrue(uploadPage.isFileUploadSuccess());
	}
	
	@Then("Upload error message shows")
	public void upload_error_message_shows() {
		assertTrue(uploadPage.isFailToUploadFile());
	}

}
