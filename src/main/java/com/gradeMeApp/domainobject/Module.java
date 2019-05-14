package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qrcode;

	private String name;

	@ManyToOne
	@JoinColumn
	private Teacher teacher;
	
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
	private List<ModuleMonth> modulemonth;

}
