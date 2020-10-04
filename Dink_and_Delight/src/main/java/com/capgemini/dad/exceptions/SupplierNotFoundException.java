package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class SupplierNotFoundException extends RuntimeException{
	
	public SupplierNotFoundException(String msg) {
		super(msg);
	}

}
