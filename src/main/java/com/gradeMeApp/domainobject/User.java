package com.gradeMeApp.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gradeMeApp.domainvalue.School;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
/*
 * User can be Teacher or Pupil
 */
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(unique = true)
	private String email;

	private String password;
	@Builder.Default
	private boolean deleted = false;

	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private School school;

	public User(User user) {
		this.setDeleted(false);
		this.setEmail(user.getEmail());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setPassword(user.getPassword());
		this.setSchool(user.getSchool());
	}
}
