package com.cg.exception;

public class PhoneException extends CustomException{

	public PhoneException(long phone) {
		super(phone);
	}
	public String toString(){
		return "Invalid Phone";
	}

}
