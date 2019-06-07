package com.gradeMeApp.datatransferobject;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gradeMeApp.domainvalue.Rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingDTO {

	@Enumerated(EnumType.STRING)
	private Rating rating;
	private String comment;

}