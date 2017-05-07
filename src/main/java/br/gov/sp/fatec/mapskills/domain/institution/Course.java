/*
 * @(#)Course.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crs_id")
	private long id;
	
	@Column(name = "crs_code")
	private String code;
	
	@Column(name = "crs_name")
	private String name;
	
	@Column(name = "crs_period")
	@Enumerated(value = EnumType.STRING)
	private CoursePeriod period;
	
	@Column(name = "ins_code", length = 10)
	private String institutionCode;
	
	public Course() {
		// CONSTRUCTOR DEFAULT
	}
		
	public String getPeriod() {
		return period.name();
	}
	
	public void setId(final long id) {
		this.id = id;
	}

}
