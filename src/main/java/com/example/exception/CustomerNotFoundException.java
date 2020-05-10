package com.example.exception;

public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String meseg) {
		super(meseg);
	}
}
