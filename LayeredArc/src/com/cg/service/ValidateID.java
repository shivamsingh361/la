package com.cg.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cg.exception.IDException;

public class ValidateID extends IDException {
	public ValidateID(long id) {
		super(id);
		isvalidateAge(id);
	}
	private static final long serialVersionUID = 1L;
	public String isvalidateAge(long id){
		Pattern pattern = Pattern.compile("[0-9]{10}");
		Matcher matcher = pattern.matcher(String.valueOf(id));
		matcher.pattern();
		if(!matcher.find())
			throw new IDException(id);	
		else 
			return "Valid ID";
	}	
}
