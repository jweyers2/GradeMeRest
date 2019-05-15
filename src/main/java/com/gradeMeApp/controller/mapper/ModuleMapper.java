package com.gradeMeApp.controller.mapper;

import com.gradeMeApp.datatransferobject.ModuleDTO;
import com.gradeMeApp.domainobject.Module;

public class ModuleMapper {

	public static Module mapToModule(ModuleDTO moduleDTO) {
		Module module = new Module(moduleDTO.getName());
		return module;
	}

	public static ModuleDTO mapToModuleDTO(Module module) {
		ModuleDTO moduleDTO = ModuleDTO.builder().qrcode(module.getQrcode()).name(module.getName()).build();
		return moduleDTO;
	}
}
