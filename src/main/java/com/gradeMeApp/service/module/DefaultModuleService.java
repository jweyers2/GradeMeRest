package com.gradeMeApp.service.module;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradeMeApp.dataaccessobject.ModuleRepository;
import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.user.UserService;

@Service
public class DefaultModuleService implements ModuleService {

	private final ModuleRepository moduleRepository;
	private final UserService userService;

	public DefaultModuleService(final ModuleRepository moduleRepository, final UserService userService) {
		this.moduleRepository = moduleRepository;
		this.userService = userService;
	}

	@Override
	public Module createModule(final long teacherId, Module module)
			throws ConstraintsViolationException, EntityNotFoundException {
		Teacher teacher = userService.getTeacher(teacherId);
		module.setTeacher(teacher);
		try {
			return moduleRepository.save(module);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"Module createn wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	public List<Module> findModules(final long userId) throws EntityNotFoundException {
		User user = userService.getUser(userId);
		if (user instanceof Teacher) {
			return moduleRepository.findByTeacher((Teacher) user);
		} else {
			return null;// TODO
		}
	}
	
	@Override
	public void addPupilToModule (final long moduleId, final long pupilId) throws EntityNotFoundException
	{
		Pupil pupil = userService.getPupil(pupilId);//TODO
		
	}

	@Override
	public Module getModule(final long teacherId, final long moduleId) throws EntityNotFoundException {
		Module module = moduleRepository.findById(moduleId).filter(mod -> Boolean.FALSE == mod.isDeleted())
				.orElseThrow(() -> new EntityNotFoundException("The module doesn't exist or is deleted"));
		if (module.getTeacher().getId() != teacherId) {
			throw new EntityNotFoundException("The module doesn't exist or isn't created by the given teacher.");
		}
		return module;
	}

	@Override
	public Module updateModule(final long teacherId, final long moduleId, Module module)
			throws EntityNotFoundException, ConstraintsViolationException {
		Module dbModule = this.getModule(teacherId, moduleId);
		module.setQrcode(moduleId);
		module.setTeacher(dbModule.getTeacher());
		try {
			return moduleRepository.save(module);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"Module createn wasn't successfull. Is some critical condition not fulfilled?");
		}
	}

	@Override
	@Transactional
	public void deleteModule(final long teacherId, final long moduleId) throws EntityNotFoundException {
		Module module = this.getModule(teacherId, moduleId);
		module.setDeleted(true);
	}

}
