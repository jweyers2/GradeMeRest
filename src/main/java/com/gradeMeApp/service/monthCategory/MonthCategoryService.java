package com.gradeMeApp.service.monthCategory;

import java.util.List;

import com.gradeMeApp.domainobject.MonthCategory;
import com.gradeMeApp.exception.ConstraintsViolationException;

public interface MonthCategoryService {

	public MonthCategory createMonthCategory(MonthCategory monthCategory) throws ConstraintsViolationException;
	public List<MonthCategory> createAndSaveAllMonthCategories() throws ConstraintsViolationException;
}
