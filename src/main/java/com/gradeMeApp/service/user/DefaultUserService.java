package com.gradeMeApp.service.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gradeMeApp.dataaccessobject.UserRepository;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;

@Service
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;

	public DefaultUserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User userDO) throws ConstraintsViolationException {
		User user;
		try {
			user = userRepository.save(userDO);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"User creation wasn't successful. Did you already created a user with this email address?");
		}
		return user;
	}

}
