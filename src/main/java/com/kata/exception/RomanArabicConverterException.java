package com.kata.exception;

public class RomanArabicConverterException extends Exception {

	private static final long serialVersionUID = 4478940905985149008L;
	
	Throwable cause;
	
	public RomanArabicConverterException(String msg) {
		super(msg);
	}

	public RomanArabicConverterException(String msg, Throwable rootCause) {
		super(msg);
		this.cause = rootCause;
	}

	public Throwable getCause() {
		return cause;
	}
	
}
