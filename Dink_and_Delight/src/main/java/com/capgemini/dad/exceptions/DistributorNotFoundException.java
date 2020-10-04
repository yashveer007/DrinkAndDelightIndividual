package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class DistributorNotFoundException extends RuntimeException{
	
	public DistributorNotFoundException(String msg) {
		super(msg);
	}
}
