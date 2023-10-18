package edu.cesur.spring.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.cesur.spring.exceptions.CocheNotFoundException;
import edu.cesur.spring.exceptions.InvalidCocheException;

@RestControllerAdvice
public class GlobalHandlerExceptions {

	
	@ExceptionHandler(CocheNotFoundException.class)
	public ProblemDetail handlerCocheNotFoundException(CocheNotFoundException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Coustom Exception Occuder");
		problemDetail.setType(URI.create("http://localhost/8080/coches"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());
		
		return problemDetail;
	}
	
	@ExceptionHandler(InvalidCocheException.class)
	public ProblemDetail handlerCocheNotFoundException(InvalidCocheException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Coustom Exception Occuder");
		problemDetail.setType(URI.create("http://localhost/8080/coches"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());
		
		return problemDetail;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handlerCocheNotFoundException(MethodArgumentNotValidException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		problemDetail.setTitle("Coustom Exception Occuder");
		problemDetail.setType(URI.create("http://localhost/8080/coches"));
		problemDetail.setProperty("errorCategory", "Coche");
		problemDetail.setProperty("timeStamp", Instant.now());
		
		return problemDetail;
	}
	
}
