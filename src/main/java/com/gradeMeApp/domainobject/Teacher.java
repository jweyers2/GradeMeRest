package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Teacher extends User {

	 public Teacher(String email, String password) {
		super(email, password);
	}

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private List<Module> modules;

}
