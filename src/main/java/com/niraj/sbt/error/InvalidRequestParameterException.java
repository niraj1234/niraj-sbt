package com.niraj.sbt.error;

public class InvalidRequestParameterException extends Exception {

	public InvalidRequestParameterException() {
		super();
	}
	
	public InvalidRequestParameterException(String message) {
		super(message);
	}
}
