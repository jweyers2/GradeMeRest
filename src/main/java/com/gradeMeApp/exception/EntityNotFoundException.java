package com.gradeMeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -3527506603087172044L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
