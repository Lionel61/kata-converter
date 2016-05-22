package com.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.controller.response.RomanArabicConverterResponse;
import com.kata.exception.RomanArabicConverterException;
import com.kata.services.RomanArabicConverterService;

@RestController
@RequestMapping("/services/")
public class RomanArabicConverterController {

    @Autowired
    private RomanArabicConverterService romanArabicConverterServiceModel;

    @Autowired
    private RomanArabicConverterService romanArabicConverterServiceEnum;
    
	@RequestMapping("enum/arabicToRoman/{arabicNumber}")
	public RomanArabicConverterResponse getRomanFromArabicEnum(@PathVariable("arabicNumber") Integer arabicNumber) {
		RomanArabicConverterResponse response = new RomanArabicConverterResponse();
		try {
			response.setRomanNumber(romanArabicConverterServiceEnum.arabicToRoman(arabicNumber));
			response.setStatus("OK");
		} catch (RomanArabicConverterException e) {
			response.setMessage(e.getMessage());
			response.setStatus("KO");
		}
		return response;
	}
	
	@RequestMapping("enum/romanToArabic/{romanNumber}")
	public RomanArabicConverterResponse getArabicFromRomanEnum(@PathVariable("romanNumber") String romanNumber) throws RomanArabicConverterException {
		RomanArabicConverterResponse response = new RomanArabicConverterResponse();
		try {
			response.setArabicNumber(romanArabicConverterServiceEnum.romanToArabic(romanNumber));
			response.setStatus("OK");
		} catch (RomanArabicConverterException e) {
			response.setMessage(e.getMessage());
			response.setStatus("KO");
		}
		return response;
	}
    
	@RequestMapping("model/arabicToRoman/{arabicNumber}")
	public RomanArabicConverterResponse getRomanFromArabicModel(@PathVariable("arabicNumber") Integer arabicNumber) {
		RomanArabicConverterResponse response = new RomanArabicConverterResponse();
		try {
			response.setRomanNumber(romanArabicConverterServiceModel.arabicToRoman(arabicNumber));
			response.setStatus("OK");
		} catch (RomanArabicConverterException e) {
			response.setMessage(e.getMessage());
			response.setStatus("KO");
		}
		return response;
	}
	
	@RequestMapping("model/romanToArabic/{romanNumber}")
	public RomanArabicConverterResponse getArabicFromRomanModel(@PathVariable("romanNumber") String romanNumber) throws RomanArabicConverterException {
		RomanArabicConverterResponse response = new RomanArabicConverterResponse();
		try {
			response.setArabicNumber(romanArabicConverterServiceModel.romanToArabic(romanNumber));
			response.setStatus("OK");
		} catch (RomanArabicConverterException e) {
			response.setMessage(e.getMessage());
			response.setStatus("KO");
		}
		return response;
	}
	
}
