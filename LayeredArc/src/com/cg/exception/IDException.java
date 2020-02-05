package com.cg.exception;

public class IDException extends CustomException{
	public IDException(long id) {
		super(id);	
	}
	public String toString(){
		return "Invalid ID Exception";
	}
	

}
