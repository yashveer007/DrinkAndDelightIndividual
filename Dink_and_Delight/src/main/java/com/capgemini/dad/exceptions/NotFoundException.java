package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends RuntimeException{
	
	public NotFoundException(String msg) {
		super(msg);
	}

}
