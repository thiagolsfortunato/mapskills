/*
 * @(#)AcademicRegistry.java 1.0 10/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.Getter;
/**
 * a classe <code>AcademicRegistry</code> eh
 * um Value Object que representa a RA do aluno,
 * que eh utilizada para recuperar algumas informacoes
 * do mesmo.
 * 
 * @author Marcelo
 *
 */
@Getter
@Embeddable
public class AcademicRegistry implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "stu_ra")
	@Size(min=13, max=14)
	private String ra;
	
	@Column(name = "ins_code", nullable = false)
	private String institutionCode;
	
	@Column(name = "crs_code", nullable = false)
	private String courseCode;
	
	public AcademicRegistry() {
		// CONSTRUCTOR DEFAULT
	}
	
	public AcademicRegistry(final String ra, final String institutionCode, final String courseCode) {
		this.ra = ra;
		this.institutionCode = institutionCode;
		this.courseCode = courseCode;
	}
	
	public String getYear() {
		return ra.substring(6, 8);
	}
	
	public String getSemester() {
		return ra.substring(8, 9);
	}
	
	public String getStudentCode() {
		return ra.substring(9);
	}
	
}
