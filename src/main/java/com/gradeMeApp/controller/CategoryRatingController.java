package com.gradeMeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gradeMeApp.controller.mapper.CategoryRatingMapper;
import com.gradeMeApp.datatransferobject.CategoryRatingDTO;
import com.gradeMeApp.datatransferobject.RatingDTO;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.categoryRating.CategoryRatingService;

@RestController
@RequestMapping("v1/ratings")
public class CategoryRatingController {

	private final CategoryRatingService categoryRatingService;

	@Autowired
	public CategoryRatingController(final CategoryRatingService categoryRatingService) {
		this.categoryRatingService = categoryRatingService;
	}

	@PutMapping("/{id}/user/{userId}")
	public CategoryRatingDTO updateCategoryRating(@PathVariable final long id, @PathVariable final long userId,
			@RequestBody RatingDTO ratingDTO) throws EntityNotFoundException {
		return CategoryRatingMapper
				.mapToCategoryRatingDTO(categoryRatingService.updateCategoryRating(id, userId, ratingDTO));
	}
}
