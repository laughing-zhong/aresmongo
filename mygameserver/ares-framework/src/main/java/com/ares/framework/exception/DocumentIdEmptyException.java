package com.ares.framework.exception;

public class DocumentIdEmptyException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8201861154191366565L;
	
	public DocumentIdEmptyException(String msg){
		super(msg);
	}

}
