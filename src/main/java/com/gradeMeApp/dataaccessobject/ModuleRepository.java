package com.gradeMeApp.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.domainobject.Teacher;

public interface ModuleRepository extends CrudRepository<Module, Long> {

	List<Module> findByTeacher(Teacher teacher);
}
