package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pupil extends User {

	public Pupil(String email, String password) {
		super(email, password);
	}

	@ManyToMany
	@JoinTable(
	  name = "moduleMonth_pupil", 
	  joinColumns = @JoinColumn(name = "pupil_id"), 
	  inverseJoinColumns = @JoinColumn(name = "moduleMonth_id"))
	private List<ModuleMonth> modulemonth;
	
}
