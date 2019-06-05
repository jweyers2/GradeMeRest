package com.gradeMeApp.controller.mapper;

import java.util.List;
import com.gradeMeApp.datatransferobject.ModuleDTO;
import com.gradeMeApp.datatransferobject.TeacherDTO;
import com.gradeMeApp.domainobject.Module;
import com.google.common.collect.Lists;

public class ModuleMapper {

	public static Module mapToModule(ModuleDTO moduleDTO) {
		Module module = new Module(moduleDTO.getName());
		return module;
	}

	public static ModuleDTO mapToModuleDTO(Module module) {
		TeacherDTO teacher = UserMapper.mapToTeacherDTO(module.getTeacher());
		ModuleDTO moduleDTO = ModuleDTO.builder().qrcode(module.getQrcode()).name(module.getName()).teacher(teacher)
				.build();
		return moduleDTO;
	}

	public static List<ModuleDTO> maptToModuleDTOList(List<Module> moduleList) {
		List<ModuleDTO> moduleDTOList = Lists.newLinkedList();
		for (Module module : moduleList) {
			moduleDTOList.add(ModuleMapper.mapToModuleDTO(module));
		}
		return moduleDTOList;
	}
}
