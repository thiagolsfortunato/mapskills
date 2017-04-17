/*
 * @(#)Institution.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "INSTITUTION")
public class Institution implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ins_id")
	private long id;
	
	@Column(name = "ins_code", nullable = false, unique = true, length = 10)
	private String code;
	
	@Column(name = "ins_cnpj", nullable = true, unique = true)
	private String cnpj;
	
	@Column(name = "ins_company", nullable = true)
	private String company;
	
	@Column(name = "ins_level", nullable = true)
	@Enumerated(value = EnumType.STRING)
	private InstitutionLevel level;
	
	@Column(name = "ins_city", nullable = true)
	private String city;
	
	@Column(name = "gth_id")
	private long gameThemeId;
	
	@Transient
	private Collection<Course> courses = new HashSet<>();
	
	@Transient
	private Collection<Mentor> mentors = new HashSet<>();

	public Institution() {
		// CONSTRUCTOR DEFAULT
	}
	
	@Builder
	public Institution (final long id, final String code, final String cnpj, final String company,
			final InstitutionLevel level, final String city, final Collection<Mentor> mentors, final long gameThemeId) {
		
		this(code, cnpj, company, level, city);
		this.id = id;
		this.gameThemeId = gameThemeId;
	}
	
	@Builder
	public Institution(final String code, final String cnpj, final String company, final InstitutionLevel level,
			final String city) {
		
		this.code = code;
		this.cnpj = cnpj;
		this.company = company;
		this.level = level;
		this.city = city;
	}	
		
	public void setCourses(final Collection<Course> courses) {
		this.courses.clear();
		this.courses.addAll(courses);
	}
	
	public void setMentors(final Collection<Mentor> mentors) {
		this.mentors.clear();
		this.mentors.addAll(mentors);
	}
		
	public Collection<Mentor> getMentors() {
		return Collections.unmodifiableCollection(mentors);
	}
	
	public Collection<Course> getCourses() {
		return Collections.unmodifiableCollection(courses);
	}

	public void addMentor(final Mentor newMentor) {
		this.mentors.add(newMentor);
	}
	
}
