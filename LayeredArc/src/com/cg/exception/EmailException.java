package com.cg.exception;

public class EmailException extends CustomException{

	private static final long serialVersionUID = 1L;
	public EmailException(String email) {
		super(email);
	}
	public String toString(){
		return "Invalid Email";
	}

}
