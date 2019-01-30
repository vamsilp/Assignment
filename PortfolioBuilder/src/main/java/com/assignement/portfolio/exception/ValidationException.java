package com.assignement.portfolio.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 8999618013689014771L;

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}
}
