package com.gradeMeApp.service.moPuMoCa;

import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.SubPuMoCa;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.exception.ConstraintsViolationException;

public interface SubPuMoCaService {

	public void createAllSubPuMoCas(Subject subject, Pupil pupil) throws ConstraintsViolationException;
	public SubPuMoCa createSubPuMoCa (SubPuMoCa subPuMoCa) throws ConstraintsViolationException;
}
