package com.gradeMeApp.service.module;

import java.util.List;

import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface ModuleService {

	public Module createModule(final long teacherId, Module module)
			throws ConstraintsViolationException, EntityNotFoundException;

	public Module getModule(final long teacherId, final long moduleId) throws EntityNotFoundException;

	public Module updateModule(final long teacherId, final long moduleId, Module module)
			throws EntityNotFoundException, ConstraintsViolationException;

	public void deleteModule(final long teacherId, final long moduleId) throws EntityNotFoundException;

	public List<Module> findModules(final long userId) throws EntityNotFoundException;

	public void addPupilToModule(final long moduleId, final long pupilId) throws EntityNotFoundException;

}
