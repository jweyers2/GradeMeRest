package com.gradeMeApp.service.user;

import com.gradeMeApp.domainobject.Pupil;
import com.gradeMeApp.domainobject.Teacher;
import com.gradeMeApp.domainobject.User;
import com.gradeMeApp.exception.ConstraintsViolationException;
import com.gradeMeApp.exception.EntityNotFoundException;

public interface UserService {

	public User createUser(User User) throws ConstraintsViolationException;

	public User getUser(final long id) throws EntityNotFoundException;

	public User updateUser(final long id, User User) throws EntityNotFoundException, ConstraintsViolationException;

	public void deleteUser(final long id) throws EntityNotFoundException;

	public User login(final String email, final String password) throws EntityNotFoundException;

	public Teacher getTeacher(final long id) throws EntityNotFoundException;

	public Pupil getPupil(final long id) throws EntityNotFoundException;
}
