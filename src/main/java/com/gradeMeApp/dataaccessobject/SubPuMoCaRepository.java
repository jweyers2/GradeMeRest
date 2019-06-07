package com.gradeMeApp.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.SubPuMoCa;

public interface SubPuMoCaRepository extends CrudRepository<SubPuMoCa, Long> {
	List<SubPuMoCa> findByPupil(Pupil pupil);
}
