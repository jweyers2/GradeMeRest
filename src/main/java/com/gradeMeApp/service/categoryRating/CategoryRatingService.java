package com.gradeMeApp.service.categoryRating;

import java.util.List;

import com.gradeMeApp.datatransferobject.RatingDTO;
import com.gradeMeApp.domainobject.CategoryRating;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface CategoryRatingService {

	public CategoryRating createCategoryRating(CategoryRating categoryRating) throws ConstraintsViolationException;
	public List<CategoryRating> createAndSaveAllCategoryRatings() throws ConstraintsViolationException;
	public CategoryRating updateCategoryRating(final long id, final long userId, RatingDTO rating) throws EntityNotFoundException;
	public CategoryRating getCategoryRating(final long id) throws EntityNotFoundException;
}
