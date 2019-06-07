package com.gradeMeApp.service.monthCategory;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.gradeMeApp.dataaccessobject.MonthCategoryRepository;
import com.gradeMeApp.domainobject.CategoryRating;
import com.gradeMeApp.domainobject.MonthCategory;
import com.gradeMeApp.domainvalue.Month;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.service.categoryRating.CategoryRatingService;

@Service
public class DefaultMonthCategoryService implements MonthCategoryService {

	private final MonthCategoryRepository monthCategoryRepository;
	private final CategoryRatingService categoryRatingService;

	public DefaultMonthCategoryService(final MonthCategoryRepository monthCategoryRepository, final CategoryRatingService categoryRatingService) {
		this.monthCategoryRepository = monthCategoryRepository;
		this.categoryRatingService=categoryRatingService;
	}

	@Override
	public MonthCategory createMonthCategory(MonthCategory monthCategory) throws ConstraintsViolationException {
		try {
			return monthCategoryRepository.save(monthCategory);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"MonthCategory creation wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	public List<MonthCategory> createAndSaveAllMonthCategories() throws ConstraintsViolationException {
		List<MonthCategory> moCaList = Lists.newLinkedList();
		for (Month month : Month.values()) {
			MonthCategory moCa = new MonthCategory(month);
			List<CategoryRating> caList = categoryRatingService.createAndSaveAllCategoryRatings();
			moCa.setCategoryRatings(caList);
			moCa=this.createMonthCategory(moCa);
			moCaList.add(moCa);
		}
		return moCaList;
	}
}