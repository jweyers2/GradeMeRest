package com.gradeMeApp.domainobject;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gradeMeApp.domainvalue.Category;
import com.gradeMeApp.domainvalue.Rating;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class CategoryRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
