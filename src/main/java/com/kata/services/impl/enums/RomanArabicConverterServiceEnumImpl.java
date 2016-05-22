package com.kata.services.impl.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.kata.enums.RomanArabicCombination;
import com.kata.exception.RomanArabicConverterException;
import com.kata.services.RomanArabicConverterService;

public class RomanArabicConverterServiceEnumImpl implements RomanArabicConverterService {

	private static int LIMIT_CONVERSION = 4999;
	
	
	public String arabicToRoman(Integer arabicNumber) throws RomanArabicConverterException, NumberFormatException {
		
		//Zero doesn't exist and is not representable
		if(arabicNumber.intValue()==0) {
			throw new RomanArabicConverterException("Zero doesn't exist and can't be processed !");
		}
		
		//it's impossible to convert a number greater than LIMIT_CONVERSION
		if(arabicNumber.intValue()>LIMIT_CONVERSION) {
			throw new RomanArabicConverterException("it's impossible to convert a number greater than "+ LIMIT_CONVERSION + " !");
		}

		StringBuilder romanNumber = new StringBuilder();
		
		List<RomanArabicCombination> combinations = new ArrayList<RomanArabicCombination>(Arrays.asList(RomanArabicCombination.values()));
		
		//we reversed the combinations list to search ONE_THOUSAND first in our numeral number to convert
		List<RomanArabicCombination> combinationsReversed = combinations
				.stream()
				.sorted(Comparator.comparing(RomanArabicCombination::getArabicValue).reversed())
				.collect(Collectors.toList());
		
		do {
			for(RomanArabicCombination romanNumeralCombination : combinationsReversed) {
				if(arabicNumber>=romanNumeralCombination.getArabicValue()) {
					romanNumber.append(romanNumeralCombination.getRomanLetters());
					arabicNumber-=romanNumeralCombination.getArabicValue();
					break;
				}
			}
		} while(arabicNumber > 0);
		
		return romanNumber.toString();
		
	}

	public Integer romanToArabic(String romanNumber) throws RomanArabicConverterException {

		Integer arabicNumber = 0;
		
		//Zero doesn't exist and is not representable
		if(StringUtils.isEmpty(romanNumber)) {
			throw new RomanArabicConverterException("Zero doesn't exist and can't be processed !");
		}
		
		if (!romanNumber.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
			throw new RomanArabicConverterException("The roman number is not spelled correctly");	
		}
		
		List<RomanArabicCombination> combinations = new ArrayList<RomanArabicCombination>(Arrays.asList(RomanArabicCombination.values()));
		
		//we reversed the combinations list to search a ONE_THOUSAND (M) occurence first in our roman number to convert
		List<RomanArabicCombination> combinationsReversed = combinations
				.stream()
				.sorted(Comparator.comparing(RomanArabicCombination::getArabicValue).reversed())
				.collect(Collectors.toList());
		
		do {
			for(RomanArabicCombination romanNumeralCombination : combinationsReversed) {

				if(romanNumber.length()>1) {
					String firstTwoCharacters = romanNumber.substring(0,2);
					
					if(romanNumeralCombination.getRomanLetters().equals(firstTwoCharacters)) {
						romanNumber = romanNumber.substring(2);
						arabicNumber += romanNumeralCombination.getArabicValue();
						break;
					} 
				}
				
				String firstCharacter = romanNumber.substring(0,1);

				if(romanNumeralCombination.getRomanLetters().equals(firstCharacter)) {
					romanNumber = romanNumber.substring(1);
					arabicNumber += romanNumeralCombination.getArabicValue();
					break;
				}
			}
		} while(romanNumber.length() > 0);
		
		return arabicNumber;
	}
	
}
