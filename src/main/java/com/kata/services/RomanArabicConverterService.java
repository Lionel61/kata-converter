package com.kata.services;

import com.kata.exception.RomanArabicConverterException;

public interface RomanArabicConverterService {

	String arabicToRoman(Integer arabicNumber) throws RomanArabicConverterException;
	
	Integer romanToArabic(String romanNumber) throws RomanArabicConverterException;

}
