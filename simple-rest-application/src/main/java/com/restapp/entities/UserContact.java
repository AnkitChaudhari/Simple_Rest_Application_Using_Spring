package com.restapp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the CONTACT_DETAILS database table.
 * 
 */

@Entity
@Table(name="CONTACT_DETAILS")
@NamedQuery(name="ContactDetails.findAll", query="SELECT u FROM UserContact u")

public class UserContact {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="empSequence",sequenceName="EMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="empSequence")
	private Integer id;
	
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String mobile;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	

}




