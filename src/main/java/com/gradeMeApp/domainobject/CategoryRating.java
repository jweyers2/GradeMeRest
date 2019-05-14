package com.gradeMeApp.domainobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gradeMeApp.domainvalue.Rating;

import lombok.Data;

@Entity
@Table
@Data
public class CategoryRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Rating ratingPupil;
	private Rating ratingTeacher;
	private String commentPupil;
	private String commentTeacher;

	@OneToOne(mappedBy = "categoryRating")
	private Category category;
}
