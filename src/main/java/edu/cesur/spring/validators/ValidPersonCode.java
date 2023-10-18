package edu.cesur.spring.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PrefixValidator.class) //Es la resriccion, le decirmos que clase va a utilizar para validar el codigo de persona
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPersonCode {

	String message() default "The string must start with 'PREFIX-'";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String value() default "PREFIX-";
}