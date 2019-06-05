package com.gradeMeApp.datatransferobject;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gradeMeApp.domainvalue.Rating;

import lombok.Data;

@Data
public class UpdateRatingDTO {

	@Enumerated(EnumType.STRING)
	private Rating rating;

	private String comment;
}
