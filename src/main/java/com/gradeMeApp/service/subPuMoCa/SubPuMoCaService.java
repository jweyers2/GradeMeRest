package com.gradeMeApp.service.subPuMoCa;

import java.util.List;

import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.SubPuMoCa;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;

public interface SubPuMoCaService {

	public void createAllSubPuMoCas(Subject subject, Pupil pupil) throws ConstraintsViolationException;
	public SubPuMoCa createSubPuMoCa (SubPuMoCa subPuMoCa) throws ConstraintsViolationException;
	public List<Subject> findAllSubjectsWithUser (User user);
}
