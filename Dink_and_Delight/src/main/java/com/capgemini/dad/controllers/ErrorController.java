package com.capgemini.dad.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.dad.dto.ExceptionResponse;
import com.capgemini.dad.exceptions.DistributorNotFoundException;
import com.capgemini.dad.exceptions.NotFoundException;
import com.capgemini.dad.exceptions.ProductNotFoundException;
import com.capgemini.dad.exceptions.RawMaterialNotFoundException;
import com.capgemini.dad.exceptions.SupplierNotFoundException;

@RestControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(value = {DistributorNotFoundException.class,SupplierNotFoundException.class,
			ProductNotFoundException.class,NotFoundException.class,RawMaterialNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleNotFoundException(Exception ex, HttpServletRequest request) {
		
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
	
	@ExceptionHandler(value = {Exception.class})
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleOtherException(Exception ex, HttpServletRequest request) {
		
		return new ExceptionResponse(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
		
	}
}
