package com.kata.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roman_arabic_combination")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "ROMAN_ARABIC_COMBINATION_ID"))
})
public class RomanArabicCombinationBean extends AbstractBean {

	@Column(name="ROMAN_LETTERS", length=2, nullable = false)
	private String romanLetters;
	
	@Column(name="ARABIC_VALUE", nullable = false)
	private Integer arabicValue;

	
	public String getRomanLetters() {
		return romanLetters;
	}

	public void setRomanLetters(String romanLetters) {
		this.romanLetters = romanLetters;
	}

	public Integer getArabicValue() {
		return arabicValue;
	}

	public void setArabicValue(Integer arabicValue) {
		this.arabicValue = arabicValue;
	}
	
}