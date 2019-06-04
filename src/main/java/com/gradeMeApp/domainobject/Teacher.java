package com.gradeMeApp.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Teacher extends User {

	public Teacher(User User) {
		super(User);
	}

	String iban;
	String bic;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private List<Module> modules;

}
