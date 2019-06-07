package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
public class Pupil extends User {

	public Pupil(User user) {
		super(user);
	}

	@OneToMany(mappedBy = "pupil", cascade = CascadeType.ALL)
	private List<SubPuMoCa> modulePupilMonthCategory;
	
	@ManyToMany(mappedBy = "pupils")
	private List<Subject> modules;

}
