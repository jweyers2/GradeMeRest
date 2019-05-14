package com.gradeMeApp.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
