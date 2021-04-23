package com.utuich.main;

public class ClockException extends Exception {
	/**
	 * my own exception for checking times
	 */
	private static final long serialVersionUID = 1L;

	public ClockException(String errorMessage) {
		super(errorMessage);
	}
}
