package com.capgemini.dad.exceptions;

@SuppressWarnings("serial")
public class AuthenticationAndAuthorizationException extends RuntimeException {
	
	public AuthenticationAndAuthorizationException(String message)
	{
		super(message);
	}

}