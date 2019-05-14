package com.gradeMeApp.datatransferobject;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	@NotNull(message = "Email can't be empty.")
	String email;
	@NotNull(message = "Password can't be empty.")
	String password;
	@Builder.Default
	boolean teacher = false;
}
