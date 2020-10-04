package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class InvalidArgumentException extends RuntimeException {
	
	public InvalidArgumentException(String msg) {
		super(msg);
	}

}
