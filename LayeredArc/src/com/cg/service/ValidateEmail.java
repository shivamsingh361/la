package com.cg.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.cg.exception.EmailException;

public class ValidateEmail extends EmailException{
	public ValidateEmail(String email) {
		super(email);
		this.isValidEmail(email);
	}

	private static final long serialVersionUID = 1L;

	public String isValidEmail(String email){
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = pattern.matcher(email);
		matcher.pattern();
		
		if(!matcher.find())
			throw new EmailException(email);
			
		else
			return "Valid Email";
	}
}
