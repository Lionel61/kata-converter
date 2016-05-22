package com.kata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.kata.model.RomanArabicCombinationBean;
import com.kata.repository.RomanArabicCombinationRepository;

@SpringBootApplication
public class RomanArabicConverterApplication {

	private final static Logger logger = LoggerFactory.getLogger(RomanArabicConverterApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RomanArabicConverterApplication.class, args);
	}
	
	@Bean
	@Profile("local")
	public CommandLineRunner initializeRomanArabicCombinations(final RomanArabicCombinationRepository romanArabicCombinationRepository) {
		
		logger.info("Initialize Roman/Arabic combinations for the conversion service");
		
		return x -> {
			
			RomanArabicCombinationBean one = new RomanArabicCombinationBean();
			one.setRomanLetters("I");
			one.setArabicValue(1);
			romanArabicCombinationRepository.save(one);
			
			RomanArabicCombinationBean four = new RomanArabicCombinationBean();
			four.setRomanLetters("IV");
			four.setArabicValue(4);
			romanArabicCombinationRepository.save(four);
			
			RomanArabicCombinationBean five = new RomanArabicCombinationBean();
			five.setRomanLetters("V");
			five.setArabicValue(5);
			romanArabicCombinationRepository.save(five);
			
			RomanArabicCombinationBean nine = new RomanArabicCombinationBean();
			nine.setRomanLetters("IX");
			nine.setArabicValue(9);
			romanArabicCombinationRepository.save(nine);
			
			RomanArabicCombinationBean ten = new RomanArabicCombinationBean();
			ten.setRomanLetters("X");
			ten.setArabicValue(10);
			romanArabicCombinationRepository.save(ten);
			
			RomanArabicCombinationBean forty = new RomanArabicCombinationBean();
			forty.setRomanLetters("XL");
			forty.setArabicValue(40);
			romanArabicCombinationRepository.save(forty);
			
			RomanArabicCombinationBean fifty = new RomanArabicCombinationBean();
			fifty.setRomanLetters("L");
			fifty.setArabicValue(50);
			romanArabicCombinationRepository.save(fifty);
			
			RomanArabicCombinationBean ninety = new RomanArabicCombinationBean();
			ninety.setRomanLetters("XC");
			ninety.setArabicValue(90);
			romanArabicCombinationRepository.save(ninety);
			
			RomanArabicCombinationBean oneHundred = new RomanArabicCombinationBean();
			oneHundred.setRomanLetters("C");
			oneHundred.setArabicValue(100);
			romanArabicCombinationRepository.save(oneHundred);
			
			RomanArabicCombinationBean fourHundred = new RomanArabicCombinationBean();
			fourHundred.setRomanLetters("CD");
			fourHundred.setArabicValue(400);
			romanArabicCombinationRepository.save(fourHundred);
			
			RomanArabicCombinationBean fiveHundred = new RomanArabicCombinationBean();
			fiveHundred.setRomanLetters("D");
			fiveHundred.setArabicValue(500);
			romanArabicCombinationRepository.save(fiveHundred);
			
			RomanArabicCombinationBean nineHundred = new RomanArabicCombinationBean();
			nineHundred.setRomanLetters("CM");
			nineHundred.setArabicValue(900);
			romanArabicCombinationRepository.save(nineHundred);
			
			RomanArabicCombinationBean oneThousand = new RomanArabicCombinationBean();
			oneThousand.setRomanLetters("M");
			oneThousand.setArabicValue(1000);
			romanArabicCombinationRepository.save(oneThousand);
			
		};
	
	}
}
