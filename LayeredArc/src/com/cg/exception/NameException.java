package com.cg.exception;

public class NameException extends CustomException {

	public NameException(String name) {
		super(name);
	}
	public String toString(){
		return "Invalid Name";
	}

}
