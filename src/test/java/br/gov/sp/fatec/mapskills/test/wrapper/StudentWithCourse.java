/*
 * @(#)StudentWithCourse.java 1.0 05/02/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.wrapper;

import br.gov.sp.fatec.mapskills.domain.institution.Course;

public class StudentWithCourse {
	
	private long id;
	private String name;
	private String ra;
	private String phone;
	private boolean completed;
	private String username;
	private String password;
	private Course course;
	
	public StudentWithCourse() {
		//DEFAULT
	}
	
	public StudentWithCourse(final long id, final String name, final String ra, final String phone,
			final boolean completed, final String username, final String password, final Course course) {
		this.id = id;
		this.name = name;
		this.ra = ra;
		this.phone = phone;
		this.completed = completed;
		this.username = username;
		this.password = password;
		this.course = course;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRa() {
		return ra;
	}

	public String getPhone() {
		return phone;
	}

	public boolean isCompleted() {
		return completed;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Course getCourse() {
		return course;
	}

}
