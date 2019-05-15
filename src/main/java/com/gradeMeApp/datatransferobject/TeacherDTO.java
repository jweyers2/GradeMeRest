package com.gradeMeApp.datatransferobject;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDTO {

	UserDTO user;
	String iban;
	String bic;
}