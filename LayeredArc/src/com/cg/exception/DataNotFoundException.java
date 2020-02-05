package com.cg.exception;

public class DataNotFoundException extends CustomException{

	private static final long serialVersionUID = 1L;
	public DataNotFoundException() {
		super("Data not Found in DB");
	}
	public String toString(){
		return "Data not found Exception!";
	}
}
