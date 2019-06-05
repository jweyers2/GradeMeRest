package com.gradeMeApp.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.gradeMeApp.domainvalue.School;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	@JsonProperty(access = Access.READ_ONLY)
	Long id;
	@NotNull(message = "Email can't be empty.")
	String email;
	@NotNull(message = "Password can't be empty.")
	String password;
	@Builder.Default
	boolean teacher = false;
	@NotNull(message = "You have to enter a name.")
	String firstName;
	@NotNull(message = "You have to enter a name.")
	String lastName;
	School school;
}
