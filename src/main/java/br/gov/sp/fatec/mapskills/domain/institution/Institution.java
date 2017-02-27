/*
 * @(#)Institution.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
	private Collection<Course> courses = new ArrayList<>();
	
	@Transient
	private Collection<Mentor> mentors = new ArrayList<>();

	public Institution() {
		// CONSTRUCTOR DEFAULT
	}
	
	public Institution(final String code, final String cnpj, final String company, final InstitutionLevel level,
			final String city, final Collection<Mentor> mentors) {
		
		this.code = code;
		this.cnpj = cnpj;
		this.company = company;
		this.level = level;
		this.city = city;
		this.mentors.addAll(mentors);
	}
	
	public void changeCnpj(final String newCnpj) {
		this.cnpj = newCnpj;
	}
	
	public void changeCompany(final String newCompany) {
		this.company = newCompany;
	}
	
	public void changeCity(final String newCity) {
		this.city = newCity;
	}
		
	public void changeGameTheme(final long gameThemeId) {
		this.gameThemeId = gameThemeId;
	}
	
	public void setCourses(final Collection<Course> courses) {
		this.courses.addAll(courses);
	}
	
	public void setMentors(final Collection<Mentor> mentors) {
		this.mentors.clear();
		this.mentors.addAll(mentors);
	}
	
	public void setId(final long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getCompany() {
		return company;
	}
	
	public InstitutionLevel getLevel() {
		return level;
	}
	
	public String getCity() {
		return city;
	}
	
	public Collection<Mentor> getMentors() {
		return Collections.unmodifiableCollection(mentors);
	}
	
	public long getThemeId() {
		return gameThemeId;
	}
	
	public Collection<Course> getCourses() {
		return Collections.unmodifiableCollection(courses);
	}
	
}
