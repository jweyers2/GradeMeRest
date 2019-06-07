package com.gradeMeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityAlreadySelectedException extends Exception {

	private static final long serialVersionUID = -1940471587112363392L;

	public EntityAlreadySelectedException(String message) {
		super(message);
	}

}
