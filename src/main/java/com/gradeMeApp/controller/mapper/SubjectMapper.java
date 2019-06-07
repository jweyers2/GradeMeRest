package com.gradeMeApp.controller.mapper;

import java.util.List;

import com.google.common.collect.Lists;
import com.gradeMeApp.datatransferobject.SubPuMoCaDTO;
import com.gradeMeApp.datatransferobject.SubjectDTO;
import com.gradeMeApp.datatransferobject.TeacherDTO;
import com.gradeMeApp.domainobject.Subject;

public class SubjectMapper {

	public static Subject mapToSubject(SubjectDTO subjectDTO) {
		Subject subject = new Subject(subjectDTO.getName());
		return subject;
	}

	public static SubjectDTO mapToSubjectDTO(Subject subject) {
		TeacherDTO teacher = UserMapper.mapToTeacherDTO(subject.getTeacher());
		List<SubPuMoCaDTO> subPuMoCas = Lists.newLinkedList();
		if (subject.getSubjectPupilMonthCategories() != null && !subject.getSubjectPupilMonthCategories().isEmpty()) {
			subPuMoCas = SubPuMoCaMapper.maptToSubPuMoCaDTOList(subject.getSubjectPupilMonthCategories());
		}
		SubjectDTO subjectDTO = SubjectDTO.builder().qrcode(subject.getQrcode()).name(subject.getName())
				.teacher(teacher).subPuMoCas(subPuMoCas).build();
		return subjectDTO;
	}

	public static List<SubjectDTO> maptToSubjectDTOList(List<Subject> subjectList) {
		List<SubjectDTO> subjectDTOList = Lists.newLinkedList();
		for (Subject subject : subjectList) {
			subjectDTOList.add(SubjectMapper.mapToSubjectDTO(subject));
		}
		return subjectDTOList;
	}
}
