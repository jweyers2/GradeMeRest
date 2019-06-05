package com.gradeMeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gradeMeApp.controller.mapper.ModuleMapper;
import com.gradeMeApp.datatransferobject.ModuleDTO;
import com.gradeMeApp.domainobject.Module;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.module.ModuleService;

@RestController
@RequestMapping("v1/modules")
public class ModuleController {

	private final ModuleService moduleService;

	@Autowired
	public ModuleController(final ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@PostMapping("/{teacherId}")
	@ResponseStatus(HttpStatus.CREATED)
	public ModuleDTO createModule(@PathVariable final long teacherId, @Valid @RequestBody ModuleDTO moduleDTO)
			throws ConstraintsViolationException, EntityNotFoundException {
		Module module = ModuleMapper.mapToModule(moduleDTO);
		return ModuleMapper.mapToModuleDTO(moduleService.createModule(teacherId, module));
	}

	@PutMapping("/{moduleId}/pupil/{pupilId}")
	public void addPupilToModule(@PathVariable final long moduleId, @PathVariable final long pupilId) throws EntityNotFoundException
	{
		moduleService.addPupilToModule(moduleId, pupilId);
	}

	@GetMapping("/{userId}")
	public List<ModuleDTO> getModules(@PathVariable final long userId) throws EntityNotFoundException {
		List<Module> modules = moduleService.findModules(userId);
		return ModuleMapper.maptToModuleDTOList(modules);
	}

	@GetMapping("/{teacherId}/module/{moduleId}")
	public ModuleDTO getModule(@PathVariable final long teacherId, @PathVariable final long moduleId)
			throws EntityNotFoundException {
		return ModuleMapper.mapToModuleDTO(moduleService.getModule(teacherId, moduleId));
	}

	@PutMapping("/{teacherId}/module/{moduleId}")
	public ModuleDTO updateModule(@PathVariable final long teacherId, @PathVariable final long moduleId,
			@RequestBody ModuleDTO moduleDTO) throws EntityNotFoundException, ConstraintsViolationException {
		Module module = ModuleMapper.mapToModule(moduleDTO);
		return ModuleMapper.mapToModuleDTO(moduleService.updateModule(teacherId, moduleId, module));
	}

	@DeleteMapping("/{teacherId}/module/{moduleId}")
	public void deleteModule(@PathVariable final long teacherId, @PathVariable final long moduleId)
			throws EntityNotFoundException {
		moduleService.deleteModule(teacherId, moduleId);
	}
}
