package com.testproject.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testproject.exceptions.TestScenarioFailException;


public abstract class CommonPage {

	public final WebDriver driver;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * checks if the html page is fully loaded yet.
	 *
	 * @return <code>true</code> if the html page has been loaded according to
	 *         browser
	 */
	public boolean isDocumentFullyLoaded() {
		String state = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState;");
		return "complete".equalsIgnoreCase(state);
	}

	public boolean isDisplay(WebElement webElement) {
		boolean result;
		try {
			waitFor(webElement);
			if (webElement.isDisplayed()) {
				result=true;
			} else {
				result=false;
			}
		} catch (NoSuchElementException e) {
			result=false;
		}
		return result;
	}

	// Wait for an element loading
	public void waitForLoading(WebElement webElement) {
		for (int i = 0; i < 30; i++) {
			try {
				if (webElement.isDisplayed()) {
					break;
				} else {
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				throw new TestScenarioFailException(e.getMessage());
			}
		}
	}

	public void waitFor(WebElement webElement) {
		for (int i = 0; i < 3; i++) {
			try {
				if (webElement.isDisplayed()) {
					break;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void waitForElement(WebElement webElement, int timeOut) {
		for (int i = 0; i < timeOut; i++) {
			try {
				if (webElement.isDisplayed()) {
					break;
				} else {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void click(WebElement webElement) throws TestScenarioFailException {
		try {
			webElement.click();
		} catch (Exception e) {
			throw new TestScenarioFailException(e.getMessage());
		}
	}

	public void clickByJS(WebElement webElement) throws TestScenarioFailException {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			throw new TestScenarioFailException(e.getMessage());
		}
	}

	public void sendKeys(WebElement webElement, String value) {
		try {
			webElement.clear();
			webElement.sendKeys(value);
		} catch (Exception e) {
			throw new TestScenarioFailException(e.getMessage());
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}