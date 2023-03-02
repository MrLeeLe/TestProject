package com.testproject.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



/**
 * Base Cucumber Java scenario class
 * @author LeeLe
 *
 */
public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
	    //TBD
	}
	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getDriverManager().getDriver().manage().deleteAllCookies();
		testContext.getDriverManager().quitDriver();
	}
}