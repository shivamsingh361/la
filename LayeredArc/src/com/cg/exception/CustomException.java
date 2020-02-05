package com.cg.exception;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;



public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	long phone;
	String name, email;
	int age;
	public CustomException(long phone){
		this.phone = phone;
		 FileHandler handler = null;
		try {
			handler = new FileHandler("basic.log", true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Logger logger = Logger.getLogger("com.cg");
	     logger.addHandler(handler);
	}
	public CustomException(String name){
		this.name = name;
	}
	public CustomException(int age){
		this.age = age;
	}
	
}
