package com.cg.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.exception.NameException;

public class ValidateName extends NameException {
	public ValidateName(String name) {
		super(name);
		this.isValidName(name);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String isValidName(String name){
		Pattern pattern = Pattern.compile("^[A-Z][a-z]");
		Matcher matcher = pattern.matcher(name);
		matcher.pattern();
		
		if(!matcher.find())
			throw new NameException(name);
		else
			return "Valid Name";
	}
}
