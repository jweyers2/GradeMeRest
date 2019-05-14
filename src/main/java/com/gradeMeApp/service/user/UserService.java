package com.gradeMeApp.service.user;

import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;

public interface UserService {

	public User createUser(User user) throws ConstraintsViolationException;
}
