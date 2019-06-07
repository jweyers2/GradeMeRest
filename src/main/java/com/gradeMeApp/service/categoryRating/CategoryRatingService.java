package com.gradeMeApp.service.categoryRating;

import java.util.List;

import com.gradeMeApp.domainobject.CategoryRating;
import com.gradeMeApp.exception.ConstraintsViolationException;

public interface CategoryRatingService {

	public CategoryRating createCategoryRating(CategoryRating categoryRating) throws ConstraintsViolationException;
	public List<CategoryRating> createAndSaveAllCategoryRatings() throws ConstraintsViolationException;
}
