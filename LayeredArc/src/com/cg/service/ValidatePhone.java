package com.cg.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.exception.PhoneException;

public class ValidatePhone extends PhoneException{
	private static final long serialVersionUID = 1L;
	
	public ValidatePhone(long phone) {
		super(phone);
		this.isValidPhone(phone);
	}
	public String isValidPhone(Long phone){
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(String.valueOf(phone));
		matcher.pattern();
		
		if(!matcher.find())
			throw new PhoneException(phone);
		else
			return "Valid Phone";
	}
}
