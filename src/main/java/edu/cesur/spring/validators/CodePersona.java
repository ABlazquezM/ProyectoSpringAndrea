package edu.cesur.spring.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CodePersonaValidartor.class)

public @interface CodePersona { //Se le da el nombre que debe tener par avalidar

	String message() default "Debes ingrsar el cñodigo de persona sigueindo este patrón: ABC123"; // Es el mensaje que aparace en la consa cuadno hay un error de validación

	Class<?>[] groups() default {}; 

	Class<? extends Payload>[] payload() default {};
	
}
