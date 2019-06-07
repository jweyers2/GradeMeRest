package com.gradeMeApp.controller.mapper;

import java.util.List;

import com.gradeMeApp.datatransferobject.SubPuMoCaDTO;
import com.gradeMeApp.datatransferobject.SubjectDTO;
import com.gradeMeApp.datatransferobject.TeacherDTO;
import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.Subject;
import com.gradeMeApp.domainobject.Pupil;
import com.google.common.collect.Lists;

public class SubjectMapper {

	public static Subject mapToSubject(SubjectDTO subjectDTO) {
		Subject subject = new Subject(subjectDTO.getName());
		return subject;
	}

	public static SubjectDTO mapToSubjectDTO(Subject subject) {
		TeacherDTO teacher = UserMapper.mapToTeacherDTO(subject.getTeacher());
		List<UserDTO> pupils = Lists.newLinkedList();
		List<SubPuMoCaDTO> subPuMoCas = Lists.newLinkedList();
		if (subject.getPupils() != null && !subject.getPupils().isEmpty()) {
			for (Pupil pupil : subject.getPupils()) {
				UserDTO user = UserMapper.mapToUserDTO(pupil);
				pupils.add(user);
			}
			subPuMoCas = SubPuMoCaMapper.maptToSubPuMoCaDTOList(subject.getModulePupilMonthCategories());
		}
		SubjectDTO subjectDTO = SubjectDTO.builder().qrcode(subject.getQrcode()).name(subject.getName())
				.teacher(teacher).pupils(pupils).subPuMoCas(subPuMoCas).build();
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
