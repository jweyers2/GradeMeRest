package com.gradeMeApp.controller.mapper;

import java.util.List;

import com.google.common.collect.Lists;
import com.gradeMeApp.datatransferobject.CategoryRatingDTO;
import com.gradeMeApp.domainobject.CategoryRating;

public class CategoryRatingMapper {

	public static CategoryRatingDTO mapToCategoryRatingDTO(CategoryRating ca) {
		CategoryRatingDTO categoryRatingtDTO = CategoryRatingDTO.builder().id(ca.getId())
				.ratingPupil(ca.getRatingPupil()).ratingTeacher(ca.getRatingTeacher())
				.commentPupil(ca.getCommentPupil()).commentTeacher(ca.getCommentTeacher()).build();
		return categoryRatingtDTO;
	}

	public static List<CategoryRatingDTO> maptToCategoryRatingDTOList(List<CategoryRating> categoryRatingList) {
		List<CategoryRatingDTO> categoryRatingDTOList = Lists.newLinkedList();
		for (CategoryRating categoryRating : categoryRatingList) {
			categoryRatingDTOList.add(CategoryRatingMapper.mapToCategoryRatingDTO(categoryRating));
		}
		return categoryRatingDTOList;
	}

}
