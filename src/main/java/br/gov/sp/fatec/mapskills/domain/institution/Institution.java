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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "institution")
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
	
	@Column(name = "ins_city", nullable = true)
	private String city;
	
	@Column(name = "ght_id")
	private long gameThemeId;
	
	@Transient
	private Collection<Course> courses = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "use_id")
	private Mentor mentor;

	public Institution() {}
	
	public Institution(final String code, final String cnpj, final String company,
			final String city, final Mentor mentor) {
		
		this.code = code;
		this.cnpj = cnpj;
		this.company = company;
		this.city = city;
		this.mentor = mentor;
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
	
	public void changeMentorName(final String newName) {
		mentor.changeName(newName);
	}
	
	public void changeGameTheme(final long gameThemeId) {
		this.gameThemeId = gameThemeId;
	}
	
	public void setCourses(final Collection<Course> courses) {
		this.courses.addAll(courses);
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
	
	public String getCity() {
		return city;
	}
	
	public Mentor getMentor() {
		return mentor;
	}
	
	public long getThemeId() {
		return gameThemeId;
	}
	
	public Collection<Course> getCourses() {
		return Collections.unmodifiableCollection(courses);
	};
	
}
