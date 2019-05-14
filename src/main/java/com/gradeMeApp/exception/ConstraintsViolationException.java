package com.gradeMeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConstraintsViolationException extends Exception {

	private static final long serialVersionUID = -1940471587112363392L;

	public ConstraintsViolationException(String message) {
		super(message);
	}

}
