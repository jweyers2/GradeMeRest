package com.gradeMeApp.controller.mapper;

import java.util.List;

import com.google.common.collect.Lists;
import com.gradeMeApp.datatransferobject.CategoryRatingDTO;
import com.gradeMeApp.datatransferobject.MonthCategoryDTO;
import com.gradeMeApp.domainobject.MonthCategory;

public class MonthCategoryMapper {

	public static MonthCategoryDTO mapToMonthCategoryDTO(MonthCategory mo) {
		List<CategoryRatingDTO> caList = CategoryRatingMapper.maptToCategoryRatingDTOList(mo.getCategoryRatings());
		MonthCategoryDTO monthCategoryDTO = MonthCategoryDTO.builder().id(mo.getId()).month(mo.getMonth())
				.categoryRatings(caList).build();
		return monthCategoryDTO;
	}

	public static List<MonthCategoryDTO> maptToMonthCategoryDTOList(List<MonthCategory> monthCategoryList) {
		List<MonthCategoryDTO> monthCategoryDTOList = Lists.newLinkedList();
		for (MonthCategory monthCategory : monthCategoryList) {
			monthCategoryDTOList.add(MonthCategoryMapper.mapToMonthCategoryDTO(monthCategory));
		}
		return monthCategoryDTOList;
	}
}
