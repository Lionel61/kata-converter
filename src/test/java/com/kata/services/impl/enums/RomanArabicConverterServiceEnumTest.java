package com.kata.services.impl.enums;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kata.configuration.ServicesConfigurationTest;
import com.kata.exception.RomanArabicConverterException;
import com.kata.services.RomanArabicConverterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServicesConfigurationTest.class)
public class RomanArabicConverterServiceEnumTest {

	@Autowired
	private RomanArabicConverterService romanArabicConverterServiceEnum;
	
	@Test
	public void test_convertNumeral_Should_Return_Roman_Characters() throws RomanArabicConverterException {

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
		String oneRoman = romanArabicConverterServiceEnum.arabicToRoman(one);
		String fourRoman = romanArabicConverterServiceEnum.arabicToRoman(four);
		String sixRoman = romanArabicConverterServiceEnum.arabicToRoman(six);
		String nineRoman = romanArabicConverterServiceEnum.arabicToRoman(nine);
		
		//Dozens
		String tenRoman = romanArabicConverterServiceEnum.arabicToRoman(ten);
		String twentyFourRoman = romanArabicConverterServiceEnum.arabicToRoman(twentyFour);
		String fiftyFiveRoman = romanArabicConverterServiceEnum.arabicToRoman(fiftyFive);
		String nintentyNineRoman = romanArabicConverterServiceEnum.arabicToRoman(nintentyNine);
		
		//Hundreds
		String oneHundredTwelveRoman = romanArabicConverterServiceEnum.arabicToRoman(oneHundredTwelve);
		String fortyHundredThirtySixRoman = romanArabicConverterServiceEnum.arabicToRoman(fortyHundredThirtySix);
		String sixtyHundredFortyTwoRoman = romanArabicConverterServiceEnum.arabicToRoman(sixtyHundredFortyTwo);
		String seventyHundredEightySevenRoman = romanArabicConverterServiceEnum.arabicToRoman(seventyHundredEightySeven);
		
		//Thousands
		String oneThousandTwoHundredThirtyThreeRoman = romanArabicConverterServiceEnum.arabicToRoman(oneThousandTwoHundredThirtyThree);
		String threeThousandSixHundredTwentyEightRoman = romanArabicConverterServiceEnum.arabicToRoman(threeThousandSixHundredTwentyEight);
		
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
	public void test_convertNumeralTooBig_Should_Return_RomanNumeralConverterException() throws RomanArabicConverterException {
		
	}
	
	@Test
	public void test_convertRoman_Characters_Should_Return_Numeral() throws RomanArabicConverterException {
		
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
		Integer oneNumeral = romanArabicConverterServiceEnum.romanToArabic(one);
		Integer fourNumeral = romanArabicConverterServiceEnum.romanToArabic(four);
		Integer sixNumeral = romanArabicConverterServiceEnum.romanToArabic(six);
		Integer nineNumeral = romanArabicConverterServiceEnum.romanToArabic(nine);
		
		//Dozens
		Integer tenNumeral = romanArabicConverterServiceEnum.romanToArabic(ten);
		Integer twentyFourNumeral = romanArabicConverterServiceEnum.romanToArabic(twentyFour);
		Integer fiftyFiveNumeral = romanArabicConverterServiceEnum.romanToArabic(fiftyFive);
		Integer nintentyNineNumeral = romanArabicConverterServiceEnum.romanToArabic(nintentyNine);
		
		//Hundreds
		Integer oneHundredTwelveNumeral = romanArabicConverterServiceEnum.romanToArabic(oneHundredTwelve);
		Integer fortyHundredThirtySixNumeral = romanArabicConverterServiceEnum.romanToArabic(fortyHundredThirtySix);
		Integer sixtyHundredFortyTwoNumeral = romanArabicConverterServiceEnum.romanToArabic(sixtyHundredFortyTwo);
		Integer seventyHundredEightySevenNumeral = romanArabicConverterServiceEnum.romanToArabic(seventyHundredEightySeven);
		
		//Thousands
		Integer oneThousandTwoHundredThirtyThreeNumeral = romanArabicConverterServiceEnum.romanToArabic(oneThousandTwoHundredThirtyThree);
		Integer threeThousandSixHundredTwentyEightNumeral = romanArabicConverterServiceEnum.romanToArabic(threeThousandSixHundredTwentyEight);
		
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
	
}
