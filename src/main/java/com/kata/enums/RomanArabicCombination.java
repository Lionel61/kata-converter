package com.kata.enums;

public enum RomanArabicCombination {

	ONE("I", 1),
	FOUR("IV", 4),
	FIVE("V",5),
	NINE("IX", 9),
	TEN("X",10),
	FORTY("XL",40),	
	FIFTY("L",50),
	NINETY("XC",90),
	ONE_HUNDRED("C",100),
	FOUR_HUNDRED("CD",400),
	FIVE_HUNDRED("D",500),
	NINE_HUNDRED("CM",900),
	ONE_THOUSAND("M",1000);

	private final String romanLetters;
	private final int arabicValue;
	
	private RomanArabicCombination(String romanLetters, int arabicValue) {
		this.romanLetters = romanLetters;
		this.arabicValue = arabicValue;
	}

	public String getRomanLetters() {
		return romanLetters;
	}
	
	public int getArabicValue() {
		return arabicValue;
	}

}
