package com.gradeMeApp.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.domainobject.Teacher;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

	List<Subject> findByTeacher(Teacher teacher);
}
