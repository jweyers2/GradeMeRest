package com.gradeMeApp.controller.mapper;

import com.gradeMeApp.datatransferobject.TeacherDTO;
import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;

public class UserMapper {

	public static User mapToUser(UserDTO userDTO) {
		User user = User.builder().email(userDTO.getEmail()).password(userDTO.getPassword())
				.firstName(userDTO.getFirstName()).lastName(userDTO.getLastName()).school(userDTO.getSchool()).build();
		if (Boolean.TRUE == userDTO.isTeacher()) {
			Teacher teacher = new Teacher(user);
			return teacher;
		} else {
			Pupil pupil = new Pupil(user);
			return pupil;
		}
	}

	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDTO = UserDTO.builder().id(user.getId()).email(user.getEmail()).password(user.getPassword())
				.firstName(user.getFirstName()).lastName(user.getLastName()).school(user.getSchool()).build();
		if (user instanceof Teacher) {
			userDTO.setTeacher(true);
		} else {
			userDTO.setTeacher(false);
		}
		return userDTO;
	}

	public static Teacher mapToTeacher(TeacherDTO teacherDTO) {
		User user = mapToUser(teacherDTO.getUser());
		Teacher teacher = new Teacher(user);
		teacher.setBic(teacherDTO.getBic());
		teacher.setIban(teacherDTO.getIban());
		return teacher;
	}

	public static TeacherDTO mapToTeacherDTO(Teacher teacher) {
		UserDTO userDTO = mapToUserDTO(teacher);
		TeacherDTO teacherDTO = TeacherDTO.builder().user(userDTO).bic(teacher.getBic()).iban(teacher.getIban())
				.build();
		return teacherDTO;
	}
}
