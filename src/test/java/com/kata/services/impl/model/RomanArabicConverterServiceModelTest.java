package com.kata.services.impl.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.kata.exception.RomanArabicConverterException;
import com.kata.model.RomanArabicCombinationBean;
import com.kata.repository.RomanArabicCombinationRepository;

public class RomanArabicConverterServiceModelTest {

	@InjectMocks
	private RomanArabicConverterServiceModelImpl romanArabicConverterServiceModel;
	
	@Mock
	private RomanArabicCombinationRepository romanArabicCombinationRepository;
	
    @Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation(){
        assertNotNull(romanArabicCombinationRepository);
    }
    
    @Test
	public void test_convertNumeral_Should_Return_Roman_Characters() throws RomanArabicConverterException {

    	//We mock the result of the romanArabicCombinationRepository.findAllByOrderByArabicValueDesc() method
    	Mockito.when(romanArabicCombinationRepository.findAllByOrderByArabicValueDesc()).thenReturn(retrieveArabicCombinations());
    	
    	//Given
		
		//Units	
		Integer one = 1;
		Integer four = 4;
		Integer six = 6;
		Integer nine = 9;

		//Dozens
		Integer ten = 10;
		Integer twentyFour = 24;
		Integer fiftyFive = 55;
		Integer nintentyNine = 99;
		
		//Hundreds
		Integer oneHundredTwelve = 112;
		Integer fortyHundredThirtySix = 436;
		Integer sixtyHundredFortyTwo = 642;
		Integer seventyHundredEightySeven = 787;

		//Thousands
		Integer oneThousandTwoHundredThirtyThree = 1233;
		Integer threeThousandSixHundredTwentyEight = 3628;
		
		//When
		
		//Units
		String oneRoman = romanArabicConverterServiceModel.arabicToRoman(one);
		String fourRoman = romanArabicConverterServiceModel.arabicToRoman(four);
		String sixRoman = romanArabicConverterServiceModel.arabicToRoman(six);
		String nineRoman = romanArabicConverterServiceModel.arabicToRoman(nine);
		
		//Dozens
		String tenRoman = romanArabicConverterServiceModel.arabicToRoman(ten);
		String twentyFourRoman = romanArabicConverterServiceModel.arabicToRoman(twentyFour);
		String fiftyFiveRoman = romanArabicConverterServiceModel.arabicToRoman(fiftyFive);
		String nintentyNineRoman = romanArabicConverterServiceModel.arabicToRoman(nintentyNine);
		
		//Hundreds
		String oneHundredTwelveRoman = romanArabicConverterServiceModel.arabicToRoman(oneHundredTwelve);
		String fortyHundredThirtySixRoman = romanArabicConverterServiceModel.arabicToRoman(fortyHundredThirtySix);
		String sixtyHundredFortyTwoRoman = romanArabicConverterServiceModel.arabicToRoman(sixtyHundredFortyTwo);
		String seventyHundredEightySevenRoman = romanArabicConverterServiceModel.arabicToRoman(seventyHundredEightySeven);
		
		//Thousands
		String oneThousandTwoHundredThirtyThreeRoman = romanArabicConverterServiceModel.arabicToRoman(oneThousandTwoHundredThirtyThree);
		String threeThousandSixHundredTwentyEightRoman = romanArabicConverterServiceModel.arabicToRoman(threeThousandSixHundredTwentyEight);
		
		//Then
		
		//Units		
		assertThat(oneRoman,is(notNullValue()));
		assertThat(oneRoman,isA(String.class));
		assertThat(oneRoman,is("I"));

		assertThat(fourRoman,is(notNullValue()));
		assertThat(fourRoman,isA(String.class));
		assertThat(fourRoman,is("IV"));
		
		assertThat(sixRoman,is(notNullValue()));
		assertThat(sixRoman,isA(String.class));
		assertThat(sixRoman,is("VI"));
		
		assertThat(nineRoman,is(notNullValue()));
		assertThat(nineRoman,isA(String.class));
		assertThat(nineRoman,is("IX"));
		
		//Dozens
		assertThat(tenRoman,is(notNullValue()));
		assertThat(tenRoman,isA(String.class));
		assertThat(tenRoman,is("X"));
		
		assertThat(twentyFourRoman,is(notNullValue()));
		assertThat(twentyFourRoman,isA(String.class));
		assertThat(twentyFourRoman,is("XXIV"));
		
		assertThat(fiftyFiveRoman,is(notNullValue()));
		assertThat(fiftyFiveRoman,isA(String.class));
		assertThat(fiftyFiveRoman,is("LV"));

		assertThat(nintentyNineRoman,is(notNullValue()));
		assertThat(nintentyNineRoman,isA(String.class));
		assertThat(nintentyNineRoman,is("XCIX"));
		
		//Hundreds
		assertThat(oneHundredTwelveRoman,is(notNullValue()));
		assertThat(oneHundredTwelveRoman,isA(String.class));
		assertThat(oneHundredTwelveRoman,is("CXII"));
		
		assertThat(fortyHundredThirtySixRoman,is(notNullValue()));
		assertThat(fortyHundredThirtySixRoman,isA(String.class));
		assertThat(fortyHundredThirtySixRoman,is("CDXXXVI"));
		
		assertThat(sixtyHundredFortyTwoRoman,is(notNullValue()));
		assertThat(sixtyHundredFortyTwoRoman,isA(String.class));
		assertThat(sixtyHundredFortyTwoRoman,is("DCXLII"));

		assertThat(seventyHundredEightySevenRoman,is(notNullValue()));
		assertThat(seventyHundredEightySevenRoman,isA(String.class));
		assertThat(seventyHundredEightySevenRoman,is("DCCLXXXVII"));		
		
		//Thousands
		assertThat(oneThousandTwoHundredThirtyThreeRoman,is(notNullValue()));
		assertThat(oneThousandTwoHundredThirtyThreeRoman,isA(String.class));
		assertThat(oneThousandTwoHundredThirtyThreeRoman,is("MCCXXXIII"));	
		
		assertThat(threeThousandSixHundredTwentyEightRoman,is(notNullValue()));
		assertThat(threeThousandSixHundredTwentyEightRoman,isA(String.class));
		assertThat(threeThousandSixHundredTwentyEightRoman,is("MMMDCXXVIII"));
    	
    	
    }
    
    @Test
	public void test_convertRoman_Characters_Should_Return_Numeral() throws RomanArabicConverterException {
		
    	//We mock the result of the romanArabicCombinationRepository.findAllByOrderByArabicValueDesc() method
    	Mockito.when(romanArabicCombinationRepository.findAllByOrderByArabicValueDesc()).thenReturn(retrieveArabicCombinations());
    	
    	
		//Given
		
		//Units	
		String one = "I";
		String four = "IV";
		String six = "VI";
		String nine = "IX";

		//Dozens
		String ten = "X";
		String twentyFour = "XXIV";
		String fiftyFive = "LV";
		String nintentyNine = "XCIX";
		
		//Hundreds
		String oneHundredTwelve = "CXII";
		String fortyHundredThirtySix = "CDXXXVI";
		String sixtyHundredFortyTwo = "DCXLII";
		String seventyHundredEightySeven = "DCCLXXXVII";

		//Thousands
		String oneThousandTwoHundredThirtyThree = "MCCXXXIII";
		String threeThousandSixHundredTwentyEight = "MMMDCXXVIII";

		//When
		Integer oneNumeral = romanArabicConverterServiceModel.romanToArabic(one);
		Integer fourNumeral = romanArabicConverterServiceModel.romanToArabic(four);
		Integer sixNumeral = romanArabicConverterServiceModel.romanToArabic(six);
		Integer nineNumeral = romanArabicConverterServiceModel.romanToArabic(nine);
		
		//Dozens
		Integer tenNumeral = romanArabicConverterServiceModel.romanToArabic(ten);
		Integer twentyFourNumeral = romanArabicConverterServiceModel.romanToArabic(twentyFour);
		Integer fiftyFiveNumeral = romanArabicConverterServiceModel.romanToArabic(fiftyFive);
		Integer nintentyNineNumeral = romanArabicConverterServiceModel.romanToArabic(nintentyNine);
		
		//Hundreds
		Integer oneHundredTwelveNumeral = romanArabicConverterServiceModel.romanToArabic(oneHundredTwelve);
		Integer fortyHundredThirtySixNumeral = romanArabicConverterServiceModel.romanToArabic(fortyHundredThirtySix);
		Integer sixtyHundredFortyTwoNumeral = romanArabicConverterServiceModel.romanToArabic(sixtyHundredFortyTwo);
		Integer seventyHundredEightySevenNumeral = romanArabicConverterServiceModel.romanToArabic(seventyHundredEightySeven);
		
		//Thousands
		Integer oneThousandTwoHundredThirtyThreeNumeral = romanArabicConverterServiceModel.romanToArabic(oneThousandTwoHundredThirtyThree);
		Integer threeThousandSixHundredTwentyEightNumeral = romanArabicConverterServiceModel.romanToArabic(threeThousandSixHundredTwentyEight);
		
		//Then
		
		//Units		
		assertThat(oneNumeral,is(notNullValue()));
		assertThat(oneNumeral,isA(Integer.class));
		assertThat(oneNumeral,is(1));

		assertThat(fourNumeral,is(notNullValue()));
		assertThat(fourNumeral,isA(Integer.class));
		assertThat(fourNumeral,is(4));
		
		assertThat(sixNumeral,is(notNullValue()));
		assertThat(sixNumeral,isA(Integer.class));
		assertThat(sixNumeral,is(6));
		
		assertThat(nineNumeral,is(notNullValue()));
		assertThat(nineNumeral,isA(Integer.class));
		assertThat(nineNumeral,is(9));
		
		//Dozens
		assertThat(tenNumeral,is(notNullValue()));
		assertThat(tenNumeral,isA(Integer.class));
		assertThat(tenNumeral,is(10));
		
		assertThat(twentyFourNumeral,is(notNullValue()));
		assertThat(twentyFourNumeral,isA(Integer.class));
		assertThat(twentyFourNumeral,is(24));
		
		assertThat(fiftyFiveNumeral,is(notNullValue()));
		assertThat(fiftyFiveNumeral,isA(Integer.class));
		assertThat(fiftyFiveNumeral,is(55));

		assertThat(nintentyNineNumeral,is(notNullValue()));
		assertThat(nintentyNineNumeral,isA(Integer.class));
		assertThat(nintentyNineNumeral,is(99));
		
		//Hundreds
		assertThat(oneHundredTwelveNumeral,is(notNullValue()));
		assertThat(oneHundredTwelveNumeral,isA(Integer.class));
		assertThat(oneHundredTwelveNumeral,is(112));
		
		assertThat(fortyHundredThirtySixNumeral,is(notNullValue()));
		assertThat(fortyHundredThirtySixNumeral,isA(Integer.class));
		assertThat(fortyHundredThirtySixNumeral,is(436));
		
		assertThat(sixtyHundredFortyTwoNumeral,is(notNullValue()));
		assertThat(sixtyHundredFortyTwoNumeral,isA(Integer.class));
		assertThat(sixtyHundredFortyTwoNumeral,is(642));

		assertThat(seventyHundredEightySevenNumeral,is(notNullValue()));
		assertThat(seventyHundredEightySevenNumeral,isA(Integer.class));
		assertThat(seventyHundredEightySevenNumeral,is(787));		
		
		//Thousands
		assertThat(oneThousandTwoHundredThirtyThreeNumeral,is(notNullValue()));
		assertThat(oneThousandTwoHundredThirtyThreeNumeral,isA(Integer.class));
		assertThat(oneThousandTwoHundredThirtyThreeNumeral,is(1233));	
		
		assertThat(threeThousandSixHundredTwentyEightNumeral,is(notNullValue()));
		assertThat(threeThousandSixHundredTwentyEightNumeral,isA(Integer.class));
		assertThat(threeThousandSixHundredTwentyEightNumeral,is(3628));	
		
	}
    
    
    private List<RomanArabicCombinationBean> retrieveArabicCombinations() {
    	
    	List<RomanArabicCombinationBean> romanArabicCombinationBeans = new ArrayList<RomanArabicCombinationBean>();
    	
		RomanArabicCombinationBean one = new RomanArabicCombinationBean();
		one.setRomanLetters("I");
		one.setArabicValue(1);
		romanArabicCombinationBeans.add(one);
		
		RomanArabicCombinationBean four = new RomanArabicCombinationBean();
		four.setRomanLetters("IV");
		four.setArabicValue(4);
		romanArabicCombinationBeans.add(four);
		
		RomanArabicCombinationBean five = new RomanArabicCombinationBean();
		five.setRomanLetters("V");
		five.setArabicValue(5);
		romanArabicCombinationBeans.add(five);
		
		RomanArabicCombinationBean nine = new RomanArabicCombinationBean();
		nine.setRomanLetters("IX");
		nine.setArabicValue(9);
		romanArabicCombinationBeans.add(nine);
		
		RomanArabicCombinationBean ten = new RomanArabicCombinationBean();
		ten.setRomanLetters("X");
		ten.setArabicValue(10);
		romanArabicCombinationBeans.add(ten);
		
		RomanArabicCombinationBean forty = new RomanArabicCombinationBean();
		forty.setRomanLetters("XL");
		forty.setArabicValue(40);
		romanArabicCombinationBeans.add(forty);
		
		RomanArabicCombinationBean fifty = new RomanArabicCombinationBean();
		fifty.setRomanLetters("L");
		fifty.setArabicValue(50);
		romanArabicCombinationBeans.add(fifty);
		
		RomanArabicCombinationBean ninety = new RomanArabicCombinationBean();
		ninety.setRomanLetters("XC");
		ninety.setArabicValue(90);
		romanArabicCombinationBeans.add(ninety);
		
		RomanArabicCombinationBean oneHundred = new RomanArabicCombinationBean();
		oneHundred.setRomanLetters("C");
		oneHundred.setArabicValue(100);
		romanArabicCombinationBeans.add(oneHundred);
		
		RomanArabicCombinationBean fourHundred = new RomanArabicCombinationBean();
		fourHundred.setRomanLetters("CD");
		fourHundred.setArabicValue(400);
		romanArabicCombinationBeans.add(fourHundred);
		
		RomanArabicCombinationBean fiveHundred = new RomanArabicCombinationBean();
		fiveHundred.setRomanLetters("D");
		fiveHundred.setArabicValue(500);
		romanArabicCombinationBeans.add(fiveHundred);
		
		RomanArabicCombinationBean nineHundred = new RomanArabicCombinationBean();
		nineHundred.setRomanLetters("CM");
		nineHundred.setArabicValue(900);
		romanArabicCombinationBeans.add(nineHundred);
		
		RomanArabicCombinationBean oneThousand = new RomanArabicCombinationBean();
		oneThousand.setRomanLetters("M");
		oneThousand.setArabicValue(1000);
		romanArabicCombinationBeans.add(oneThousand);
		
		return romanArabicCombinationBeans.stream().sorted(Comparator.comparing(RomanArabicCombinationBean::getArabicValue).reversed()).collect(Collectors.toList());
		
    }
    
}
