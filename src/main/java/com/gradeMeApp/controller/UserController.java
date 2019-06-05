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

import com.gradeMeApp.controller.mapper.UserMapper;
import com.gradeMeApp.datatransferobject.RegisterUserDTO;
import com.gradeMeApp.datatransferobject.TeacherDTO;
import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;
import com.gradeMeApp.service.user.UserService;

@RestController
@RequestMapping("v1/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException {
		User user = UserMapper.mapToUser(userDTO);
		return UserMapper.mapToUserDTO(userService.createUser(user));
	}

	@GetMapping("/login")
	public UserDTO login(@Valid @RequestBody RegisterUserDTO userDTO) throws EntityNotFoundException {
		User user = userService.login(userDTO.getEmail(), userDTO.getPassword());
		return UserMapper.mapToUserDTO(user);
	}

	@GetMapping("/{id}")
	public UserDTO getUser(@PathVariable final long id) throws EntityNotFoundException {
		return UserMapper.mapToUserDTO(userService.getUser(id));
	}

	@PutMapping("/{id}/user")
	public UserDTO updateUser(@PathVariable final long id, @RequestBody UserDTO userDTO)
			throws EntityNotFoundException, ConstraintsViolationException {
		User user = UserMapper.mapToUser(userDTO);
		return UserMapper.mapToUserDTO(userService.updateUser(id, user));
	}

	@PutMapping("/{id}/teacher")
	public UserDTO updateTeacher(@PathVariable final long id, @RequestBody TeacherDTO teacherDTO)
			throws EntityNotFoundException, ConstraintsViolationException {
		Teacher teacher = UserMapper.mapToTeacher(teacherDTO);
		return UserMapper.mapToUserDTO(userService.updateUser(id, teacher));
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable final long id) throws EntityNotFoundException {
		userService.deleteUser(id);
	}

}
