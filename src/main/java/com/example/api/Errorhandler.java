package com.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.exception.Applicationerror;
import com.example.exception.CustomerNotFoundException;
/* CustomerNotFoundException.java -> throw exception from service get custo function -> Applicationerror -> Errorhandler */
@ControllerAdvice
@RestController
public class Errorhandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Applicationerror> handleCustoNotFoundException(CustomerNotFoundException customerNotFoundException, WebRequest webRequest){
		Applicationerror error = new Applicationerror();
		error.setCode(101);
		error.setMeseg(customerNotFoundException.getMessage());
		return new ResponseEntity<Applicationerror>(error,HttpStatus.NOT_FOUND);
	}
}
