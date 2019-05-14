package com.gradeMeApp.dataaccessobject;

import org.springframework.data.repository.CrudRepository;

import com.gradeMeApp.domainobject.User;

public interface UserRepository extends CrudRepository<User, String> {

}
