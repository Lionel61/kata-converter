package com.kata.controller.response;

public class RomanArabicConverterResponse {

	private String status;
	
	private String message;
	
	private String romanNumber;

	private Integer arabicNumber;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRomanNumber() {
		return romanNumber;
	}

	public void setRomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}

	public Integer getArabicNumber() {
		return arabicNumber;
	}

	public void setArabicNumber(Integer arabicNumber) {
		this.arabicNumber = arabicNumber;
	}
	
}
