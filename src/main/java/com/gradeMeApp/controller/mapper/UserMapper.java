package com.gradeMeApp.controller.mapper;

import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;

public class UserMapper {

	public static User mapToUser(UserDTO userDTO) {
		if (Boolean.TRUE == userDTO.isTeacher()) {
			Teacher teacher = new Teacher(userDTO.getEmail(), userDTO.getPassword());
			return teacher;
		} else {
			Pupil pupil = new Pupil(userDTO.getEmail(), userDTO.getPassword());
			return pupil;
		}
	}

	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDTO = UserDTO.builder().email(user.getEmail()).password(user.getPassword()).build();
		boolean teacher = false;
		if (user instanceof Teacher) {
			teacher = true;
		}
		userDTO.setTeacher(teacher);
		return userDTO;
	}
}
