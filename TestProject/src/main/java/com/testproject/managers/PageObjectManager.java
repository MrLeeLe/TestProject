package com.testproject.managers;

import org.openqa.selenium.WebDriver;
import com.testproject.pageobjects.uploadpage.UploadPage;


public class PageObjectManager {
	private WebDriver driver;
	
	//Upload page
	private UploadPage uploadPage;

	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public UploadPage getUploadPage() {
		return (uploadPage == null) ? uploadPage = new UploadPage(driver) : uploadPage;
	}
	

	

		
}
