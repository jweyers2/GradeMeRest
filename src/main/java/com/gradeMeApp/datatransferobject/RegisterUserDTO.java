package com.gradeMeApp.datatransferobject;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RegisterUserDTO {

	@NotNull(message = "Email can't be empty.")
	String email;
	@NotNull(message = "Password can't be empty.")
	String password;
}
