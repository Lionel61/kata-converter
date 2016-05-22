package com.kata.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kata.services.RomanArabicConverterService;
import com.kata.services.impl.enums.RomanArabicConverterServiceEnumImpl;
import com.kata.services.impl.model.RomanArabicConverterServiceModelImpl;

@Configuration
public class ServicesConfiguration {

	@Bean
	public RomanArabicConverterService romanArabicConverterServiceEnum() {
		return new RomanArabicConverterServiceEnumImpl();
	}

	@Bean
	public RomanArabicConverterService romanArabicConverterServiceModel() {
		return new RomanArabicConverterServiceModelImpl();
	}
	
}
