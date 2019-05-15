package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gradeMeApp.domainvalue.Month;

import lombok.Data;

@Entity
@Table
@Data
public class ModuleMonth {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Month month;
	private boolean deleted = false;

	@ManyToOne
	@JoinColumn
	private User User;

	@ManyToMany(mappedBy = "Usermonth")
	private List<Pupil> pupils;

}
