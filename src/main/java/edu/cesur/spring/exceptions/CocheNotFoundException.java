package edu.cesur.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CocheNotFoundException extends RuntimeException {

	String msg;
	
	public CocheNotFoundException(String msg) {
		super(msg);
	}
}
