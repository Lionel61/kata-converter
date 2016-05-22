package com.kata.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kata.services.RomanArabicConverterService;
import com.kata.services.impl.enums.RomanArabicConverterServiceEnumImpl;

@Configuration
public class ServicesConfigurationTest {

	@Bean
	public RomanArabicConverterService romanArabicConverterServiceEnum() {
		return new RomanArabicConverterServiceEnumImpl();
	}
	
}
