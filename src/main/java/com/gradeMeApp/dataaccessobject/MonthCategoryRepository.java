package com.gradeMeApp.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import com.gradeMeApp.domainobject.MonthCategory;

public interface MonthCategoryRepository extends CrudRepository<MonthCategory, Long> {

}
