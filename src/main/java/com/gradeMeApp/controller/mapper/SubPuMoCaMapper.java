package com.gradeMeApp.controller.mapper;

import java.util.List;

import com.google.common.collect.Lists;
import com.gradeMeApp.datatransferobject.MonthCategoryDTO;
import com.gradeMeApp.datatransferobject.SubPuMoCaDTO;
import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.SubPuMoCa;

public class SubPuMoCaMapper {

	public static SubPuMoCaDTO mapToSubPuMoCaDTO(SubPuMoCa subPuMoCa) {
		List<MonthCategoryDTO> moCaList = MonthCategoryMapper
				.maptToMonthCategoryDTOList(subPuMoCa.getMonthCategories());
		UserDTO pupilDTO = UserMapper.mapToUserDTO(subPuMoCa.getPupil());
		SubPuMoCaDTO subPuMoCaDTO = SubPuMoCaDTO.builder().id(subPuMoCa.getId()).pupil(pupilDTO)
				.monthCategories(moCaList).build();
		return subPuMoCaDTO;
	}

	public static List<SubPuMoCaDTO> maptToSubPuMoCaDTOList(List<SubPuMoCa> subPuMoCaList) {
		List<SubPuMoCaDTO> subPuMoCaDTOList = Lists.newLinkedList();
		for (SubPuMoCa subPuMoCa : subPuMoCaList) {
			subPuMoCaDTOList.add(SubPuMoCaMapper.mapToSubPuMoCaDTO(subPuMoCa));
		}
		return subPuMoCaDTOList;
	}
}
