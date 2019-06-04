package com.gradeMeApp.service.user;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradeMeApp.dataaccessobject.UserRepository;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

@Service
public class DefaultUserService implements UserService {

	private final UserRepository userRepository;

	public DefaultUserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User userDO) throws ConstraintsViolationException {
		User user;
//		String password = new BCryptPasswordEncoder().encode(UserDO.getPassword()); TODO
		try {
			user = userRepository.save(userDO);// TODO password encoding?
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintsViolationException(
					"Operation wasn't successful. Is the email address already connected to an other User?");
		}
		return user;
	}

	@Override
	public User login(String email, String password) throws EntityNotFoundException{
		User user = getUser(email);
		if (user.getPassword()!=password)
		{
			throw new EntityNotFoundException("A user with this username and password doesn't exist.");
		}
		return user;
	}

	@Override
	public User getUser(Long id) throws EntityNotFoundException {
		return userRepository.findById(id).filter(user -> Boolean.FALSE == user.isDeleted())
				.orElseThrow(() -> new EntityNotFoundException("The user doesn't exist or is deleted"));
	}

	private User getUser(String email) throws EntityNotFoundException {
		return userRepository.findByEmail(email).filter(user -> Boolean.FALSE == user.isDeleted())
				.orElseThrow(() -> new EntityNotFoundException("The user doesn't exist or is deleted"));
	}

	private boolean existUser(Long id) {
		return userRepository.findById(id).filter(user -> Boolean.FALSE == user.isDeleted()).isPresent();
	}

	@Override
	public User updateUser(final Long id, User user) throws EntityNotFoundException, ConstraintsViolationException {

		if (existUser(id)) {
			user.setId(id);
			return createUser(user);
		}
		throw new EntityNotFoundException("The user with id " + id + " doesn't exist");

	}

	@Transactional
	@Override
	public void deleteUser(Long id) throws EntityNotFoundException {
		User user = getUser(id);
		user.setDeleted(false);

	}

//	@Override
//	public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException {
//		User User;
//		Right right;
//		try {
//			User = getUser(Username);
//			if (User instanceof Teacher) {
//				right = Right.TEACHER;
//			} else {
//				right = Right.PUPIL;
//			}
//		} catch (EntityNotFoundException e) {
//			throw new UsernameNotFoundException("Username " + Username + " doesn't exist.");
//		}
//
//		return new org.springframework.security.core.Userdetails.User(User.getEmail(), User.getPassword(),
//				AuthorityUtils.commaSeparatedStringToAuthorityList(right.name()));
//	}

}
