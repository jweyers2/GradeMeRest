package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long qrcode;

	private String name;

	private boolean deleted = false;

	@ManyToOne
	private Teacher teacher;

	@ManyToMany
	@JoinTable(name = "PUPIL_MODULE", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "pupil_id"))
	private List<Pupil> pupils;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<SubPuMoCa> subjectPupilMonthCategories;

	public Subject(final String name) {
		this.name = name;
	}

	public void addPupil(Pupil pupil) {
		this.pupils.add(pupil);
	}

}
