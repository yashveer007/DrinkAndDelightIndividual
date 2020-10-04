package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String msg)
	{
		super(msg);
	}

	
}
