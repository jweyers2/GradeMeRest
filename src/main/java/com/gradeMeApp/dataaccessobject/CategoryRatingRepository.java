package com.gradeMeApp.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import com.gradeMeApp.domainobject.CategoryRating;

public interface CategoryRatingRepository extends CrudRepository<CategoryRating, Long> {

}
