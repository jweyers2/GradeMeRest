package com.gradeMeApp.datatransferobject;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gradeMeApp.domainvalue.Month;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthCategoryDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private Month month;
	List<CategoryRatingDTO> categoryRatings;
}
