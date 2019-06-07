package com.gradeMeApp.datatransferobject;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gradeMeApp.domainvalue.Category;
import com.gradeMeApp.domainvalue.Rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryRatingDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private Category category;

	@Enumerated(EnumType.STRING)
	private Rating ratingPupil;
	@Enumerated(EnumType.STRING)
	private Rating ratingTeacher;

	private String commentPupil;
	private String commentTeacher;

}
