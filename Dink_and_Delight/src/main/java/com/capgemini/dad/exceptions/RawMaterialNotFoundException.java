package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class RawMaterialNotFoundException extends RuntimeException{

	public RawMaterialNotFoundException(String msg)
	{
		super(msg);
	}
}
