package com.gradeMeApp.controller;

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

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ModuleDTO createModule(@Valid @RequestBody ModuleDTO moduleDTO) throws ConstraintsViolationException {
		Module module = ModuleMapper.mapToModule(moduleDTO);
		return ModuleMapper.mapToModuleDTO(moduleService.createModule(module));
	}

	@GetMapping("/{id}")
	public ModuleDTO getmodule(@PathVariable final Long id) throws EntityNotFoundException {
		return ModuleMapper.mapToModuleDTO(moduleService.getModule(id));
	}

	@PutMapping("/{id}")
	public ModuleDTO updateModule(@PathVariable final Long id, @RequestBody ModuleDTO moduleDTO)
			throws EntityNotFoundException, ConstraintsViolationException {
		Module module = ModuleMapper.mapToModule(moduleDTO);
		return ModuleMapper.mapToModuleDTO(moduleService.updateModule(id, module));
	}

	@DeleteMapping("/{id}")
	public void deleteModule(@PathVariable final Long id) throws EntityNotFoundException {
		moduleService.deleteModule(id);
	}
}
