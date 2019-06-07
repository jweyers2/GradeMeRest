package com.gradeMeApp.service.categoryRating;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.gradeMeApp.dataaccessobject.CategoryRatingRepository;
import com.gradeMeApp.datatransferobject.RatingDTO;
import com.gradeMeApp.domainobject.CategoryRating;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.domainvalue.Category;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.user.UserService;

@Service
public class DefaultCategoryRatingService implements CategoryRatingService {

	private final CategoryRatingRepository categoryRatingRepository;
	private final UserService userService;

	public DefaultCategoryRatingService(final CategoryRatingRepository categoryRatingRepository,
			final UserService userService) {
		this.categoryRatingRepository = categoryRatingRepository;
		this.userService = userService;
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

	@Override
	@Transactional
	public CategoryRating updateCategoryRating(long id, long userId, RatingDTO rating) throws EntityNotFoundException {
		User user = userService.getUser(userId);
		CategoryRating ca = this.getCategoryRating(id);
		if (user instanceof Teacher) {
			ca.setCommentTeacher(rating.getComment());
			ca.setRatingTeacher(rating.getRating());
		} else {
			ca.setCommentPupil(rating.getComment());
			ca.setRatingPupil(rating.getRating());
		}
		return ca;
	}

	@Override
	public CategoryRating getCategoryRating(final long id) throws EntityNotFoundException {
		return categoryRatingRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("The CategoryRating doesn't exist or is deleted"));
	}
}