package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Pupil extends User {

	public Pupil(User user) {
		super(user);
	}

	@ManyToMany
	@JoinTable(name = "UserMonth_pupil", joinColumns = @JoinColumn(name = "pupil_id"), inverseJoinColumns = @JoinColumn(name = "UserMonth_id"))
	private List<ModuleMonth> Usermonth;

}
