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
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qrcode;

	private String name;

	private boolean deleted = false;

	@ManyToOne
	@JoinColumn
	private Teacher teacher;

	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
	private List<ModuleMonth> Usermonth;

	public Module(final String name) {
		this.name = name;
	}

}
