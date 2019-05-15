package com.gradeMeApp.dataaccessobject;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(final String email);
}
