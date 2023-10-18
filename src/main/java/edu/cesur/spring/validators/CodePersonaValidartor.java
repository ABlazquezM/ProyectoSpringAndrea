package edu.cesur.spring.validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CodePersonaValidartor implements ConstraintValidator<CodePersona, String> { //Para decirle que tien que ser una clase validadora 

	public static final  Pattern PERSONA_CODE = Pattern.compile("^[A-Za-z]{3}\\d{3}$"); // El patron para validar
	
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value == null) {
			return false;
		}
		
		Matcher matcher = PERSONA_CODE.matcher(value);
			
		return matcher.matches();
	}

}
