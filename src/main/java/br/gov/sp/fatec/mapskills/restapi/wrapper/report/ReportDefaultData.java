/*
 * @(#)ReportDefaultData.java 1.0 18/03/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import lombok.Getter;

/**
 * 
 * A classe {@link ReportDefaultData} representa a view
 * da base de dados com as informações para os relatorios simples.
 *
 * @author Marcelo
 * @version 1.0 18/03/2017
 */
@Getter
@Entity
@Immutable
@Table(name = "CSV_REPORT_VIEW")
public class ReportDefaultData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id", updatable = false, nullable = false) private long studentId;
	@Column(name="student_ra", updatable = false, nullable = false) private String studentRA;
	@Column(name="student_name", updatable = false, nullable = false) private String studentName;
	@Column(name="course_code", updatable = false, nullable = false) private String courseCode;
	@Column(name="course", updatable = false, nullable = false) private String courseName;
	@Column(name="institution_code", updatable = false, nullable = false) private String institutionCode;
	@Column(name="institution", updatable = false, nullable = false) private String institutionCompany;
	@Column(name="institution_level", updatable = false, nullable = false) private String institutionLevel;
	@Column(name="yaer_semester", updatable = false, nullable = false) private String yaerSemester;
	@Transient private List<Object> scores = new ArrayList<>();
	
	public ReportDefaultData() {
		//DEFAULT CONSTRUCTOR
	}
	
	public ReportDefaultData(final long studentId, final String studentRA, final String studentName,
			final String courseCode, final String courseName,final String institutionCode,
			final String institutionCompany, final InstitutionLevel institutionLevel, final String yaerSemester) {

		this.studentId = studentId;
		this.studentRA = studentRA;
		this.studentName = studentName;
		this.courseName = courseName;
		this.institutionCode = institutionCode;
		this.institutionCompany = institutionCompany;
		this.institutionLevel = institutionLevel.name();
		this.yaerSemester = yaerSemester;
		this.courseCode = courseCode;
	}
	
	public InstitutionLevel getInstitutionLevel() {
		return InstitutionLevel.valueOf(institutionLevel);
	}
	
	public void setScores(final List<Object> scores) {
		this.scores.addAll(scores);
	}
	
	public List<Object> getScores() {
		return Collections.unmodifiableList(this.scores);
	}

}
