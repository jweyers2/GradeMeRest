package com.gradeMeApp.service.module;

import java.util.List;

import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityAlreadySelectedException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface SubjectService {

	public Subject createSubject(final long teacherId, Subject subject)
			throws ConstraintsViolationException, EntityNotFoundException;

	public Subject getSubject(final long subjectId) throws EntityNotFoundException;

	public Subject updateSubject(final long subjectId, final long teacherId, Subject subject)
			throws EntityNotFoundException, ConstraintsViolationException;

	public void deleteSubject(final long subjectId, final long teacherId) throws EntityNotFoundException;

	public List<Subject> findSubjects(final long userId) throws EntityNotFoundException;

	public void addPupilToSubject(final long subjectId, final long pupilId)
			throws EntityNotFoundException, EntityAlreadySelectedException, ConstraintsViolationException;

}
