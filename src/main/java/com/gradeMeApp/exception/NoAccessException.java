package com.gradeMeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoAccessException extends Exception {

	private static final long serialVersionUID = -2244946586897660469L;

	public NoAccessException(String message) {
		super(message);
	}

}
