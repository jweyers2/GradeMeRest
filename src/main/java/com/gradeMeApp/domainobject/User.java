package com.gradeMeApp.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
/*
 * User can be Teacher or Pupil
 */
public class User {

	@Column(unique = true)
	@Id
	private String email;

	@Column
	private String password;
}
