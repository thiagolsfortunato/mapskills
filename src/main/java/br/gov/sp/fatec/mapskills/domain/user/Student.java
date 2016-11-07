/*
 * @(#)Student.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "use_id")
public class Student extends User {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "stu_ra", nullable = false)
	private int ra;
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "stu_isCompleted")
	private boolean completed = false;
	
	@Column(name = "crs_code", nullable = false)
	private int courseCode;
	
	public Student() { }
	
	public Student(final String name, final int ra, final String phone, final int courseCode, final String username, final String password) {
		super(name, new Login(username, password), ProfileType.STUDENT);
		this.ra = ra;
		this.phone = phone;
		this.courseCode = courseCode;
	}

}