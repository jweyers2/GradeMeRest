package com.gradeMeApp.service.user;

import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface UserService {

	public User createUser(User User) throws ConstraintsViolationException;

	public User getUser(Long id) throws EntityNotFoundException;

	public User updateUser(Long id, User User) throws EntityNotFoundException, ConstraintsViolationException;

	public void deleteUser(Long id) throws EntityNotFoundException;
}
