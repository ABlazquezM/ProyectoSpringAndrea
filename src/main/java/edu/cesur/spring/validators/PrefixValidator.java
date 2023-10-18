package edu.cesur.spring.validators;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrefixValidator implements ConstraintValidator<ValidPersonCode, String>{
 
	//Definimos el patron
	private static final Pattern CODE_PATTERN = Pattern.compile("^[A-za-z]{3}\\d{3}$");
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
