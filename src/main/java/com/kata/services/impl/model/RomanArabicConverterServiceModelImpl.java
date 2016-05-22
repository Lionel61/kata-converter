package com.kata.services.impl.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.kata.exception.RomanArabicConverterException;
import com.kata.model.RomanArabicCombinationBean;
import com.kata.repository.RomanArabicCombinationRepository;
import com.kata.services.RomanArabicConverterService;

public class RomanArabicConverterServiceModelImpl implements RomanArabicConverterService {

	private static int LIMIT_CONVERSION = 4999;
	
	@Autowired
	private RomanArabicCombinationRepository romanArabicCombinationRepository;
	
	
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
		
		//we want the combinations list to search a ONE_THOUSAND (M) occurence first in our roman number to convert
		List<RomanArabicCombinationBean> combinations = romanArabicCombinationRepository.findAllByOrderByArabicValueDesc();
		
		do {
			for(RomanArabicCombinationBean romanNumeralCombination : combinations) {
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
		
		//we want the combinations list to search a ONE_THOUSAND (M) occurence first in our roman number to convert
		List<RomanArabicCombinationBean> combinations = romanArabicCombinationRepository.findAllByOrderByArabicValueDesc();
		
		do {
			for(RomanArabicCombinationBean romanNumeralCombination : combinations) {

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
