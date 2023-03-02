package com.testproject.base;

import com.testproject.managers.DriverManager;
import com.testproject.managers.PageObjectManager;

public class TestContext {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext(){
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
	}
	
	public DriverManager getDriverManager() {
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}
