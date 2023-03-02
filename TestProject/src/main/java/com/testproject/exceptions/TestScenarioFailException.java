package com.testproject.exceptions;

public class TestScenarioFailException extends AssertionError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	public TestScenarioFailException(String message) {
		super(message);
	}
}
