package com.gradeMeApp.datatransferobject;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectDTO {

	// @JsonProperty(access = Access.READ_ONLY)
	Long qrcode;
	@NotNull(message = "Module name can't be empty.")
	private String name;
	// @JsonProperty(access = Access.READ_ONLY)
	TeacherDTO teacher;

	// @JsonProperty(access = Access.READ_ONLY)
	List<SubPuMoCaDTO> subPuMoCas;
}
