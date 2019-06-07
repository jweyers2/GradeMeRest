package com.gradeMeApp.datatransferobject;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubPuMoCaDTO {

	private Long id;

	private List<MonthCategoryDTO> monthCategories;
	private UserDTO pupil;

}
