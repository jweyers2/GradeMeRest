package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class SubPuMoCa {// stands for SubjectPupilMonthCategory

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private List<MonthCategory> monthCategories;

	private boolean deleted = false;

	@ManyToOne
	private Subject subject;
	@ManyToOne
	private Pupil pupil;

	public SubPuMoCa(Subject subject, Pupil pupil) {
		this.setSubject(subject);
		this.setPupil(pupil);
	}

}
