package com.gradeMeApp.service.module;

import org.springframework.stereotype.Service;

import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

@Service
public class DefaultModuleService implements ModuleService {

	@Override
	public Module createModule(Module module) throws ConstraintsViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module getModule(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module updateModule(Long id, Module User) throws EntityNotFoundException, ConstraintsViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModule(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub

	}

}
