package com.gradeMeApp.service.module;

import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface ModuleService {

	public Module createModule(Module module) throws ConstraintsViolationException;

	public Module getModule(Long id) throws EntityNotFoundException;

	public Module updateModule(Long id, Module User) throws EntityNotFoundException, ConstraintsViolationException;

	public void deleteModule(Long id) throws EntityNotFoundException;
}
