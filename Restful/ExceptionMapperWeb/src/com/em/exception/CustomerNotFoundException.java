package com.em.exception;

public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException() {
		super();
	}

	public CustomerNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CustomerNotFoundException(String arg0) {
		super(arg0);
	}

}
