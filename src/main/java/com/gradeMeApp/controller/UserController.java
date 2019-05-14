package com.gradeMeApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gradeMeApp.controller.mapper.UserMapper;
import com.gradeMeApp.datatransferobject.UserDTO;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
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
	public UserDTO createUser(@Valid @RequestBody UserDTO userDTO)  throws ConstraintsViolationException {
		User user = UserMapper.mapToUser(userDTO);
		return UserMapper.mapToUserDTO(userService.createUser(user));
	}

}
