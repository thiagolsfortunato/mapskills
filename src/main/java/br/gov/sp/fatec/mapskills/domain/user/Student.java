/*
 * @(#)Student.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "use_id")
public class Student extends User {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	private AcademicRegistry ra;
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "stu_isCompleted")
	private boolean completed = false;
		
	public Student() { }
	
	public Student(final AcademicRegistry ra, final String name, final String phone, final String username,
			final String password) throws MapSkillsException {
		
		super(name, new Login(username, password), ProfileType.STUDENT);
		this.ra = ra;
		this.phone = phone;
	}
	
	public String getRa() {
		return ra.getRa();
	}
	
	public String getCourseCode() {
		return ra.getCourseCode();
	}
	
	public String getInstitutionCode() {
		return ra.getInstitutionCode();
	}
	
	public String getPhone() {
		return phone;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void completed() {
		completed = true;
	}

}
