package com.cg.exception;

public class DeleteException  extends CustomException{

	private static final long serialVersionUID = 1L;
	public DeleteException() {
		super("Delete Exception");
	}
	public String toString(){
		return "Can't delete, Already empty!";
	}

}
