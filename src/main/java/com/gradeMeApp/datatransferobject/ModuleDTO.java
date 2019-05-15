package com.gradeMeApp.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuleDTO {

	@JsonIgnore
	Long qrcode;
	@NotNull(message = "Module name can't be empty.")
	private String name;
}
