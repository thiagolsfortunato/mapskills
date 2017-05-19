/*
 * @(#)Student.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user.student;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.user.Login;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "STUDENT")
@PrimaryKeyJoinColumn(name = "use_id")
public class Student extends User {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	private AcademicRegistry ra;
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "stu_is_completed")
	private boolean completed;
		
	public Student() {
		// CONSTRUCTOR DEFAULT
	}
	
	@Builder
	public Student(final AcademicRegistry ra, final String name, final String phone, final String username,
			final String password) {
		
		super(name, new Login(username, password), ProfileType.STUDENT);
		this.ra = ra;
		this.phone = phone;
		this.completed = false;
	}
	
	public String getRa() {
		return ra.getRa();
	}
	
	public AcademicRegistry getAcademicRegistry() {
		return ra;
	}
	
	public String getCourseCode() {
		return ra.getCourseCode();
	}
	
	public String getInstitutionCode() {
		return ra.getInstitutionCode();
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void completed() {
		completed = true;
	}
	
	public void update(final Student studentUpdate) {
		super.setName(studentUpdate.getName());
		super.setLogin(studentUpdate.getLogin());
		this.ra = studentUpdate.getAcademicRegistry();
		this.phone = studentUpdate.getPhone();		
	}

}
