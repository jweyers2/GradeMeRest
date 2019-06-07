package com.gradeMeApp.service.categoryRating;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.gradeMeApp.dataaccessobject.CategoryRatingRepository;
import com.gradeMeApp.domainobject.CategoryRating;
import com.gradeMeApp.domainvalue.Category;
import com.gradeMeApp.exception.ConstraintsViolationException;

@Service
public class DefaultCategoryRatingService implements CategoryRatingService {

	private final CategoryRatingRepository categoryRatingRepository;

	public DefaultCategoryRatingService(final CategoryRatingRepository categoryRatingRepository) {
		this.categoryRatingRepository = categoryRatingRepository;
	}

	@Override
	public CategoryRating createCategoryRating(CategoryRating categoryRating) throws ConstraintsViolationException {
		try {
			return categoryRatingRepository.save(categoryRating);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"CategoryRating creation wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	public List<CategoryRating> createAndSaveAllCategoryRatings() throws ConstraintsViolationException {
		List<CategoryRating> caList = Lists.newLinkedList();
		for (Category category : Category.values()) {
			CategoryRating ca = new CategoryRating(category);
			ca = this.createCategoryRating(ca);
			caList.add(ca);
		}
		return caList;
	}
}