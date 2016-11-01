/*
 * @(#)Institution.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.Serializable;

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

@Entity
@Table(name = "institution")
public class Institution implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ins_id")
	private Integer id;
	
	@Column(name = "ins_cnpj", nullable = true, unique = true)
	private String cnpj;
	
	@Column(name = "ins_company", nullable = true)
	private String company;
	
	@Column(name = "ins_city", nullable = true)
	private String city;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "men_id")
	private Mentor mentor;

	public Institution() {}
	
	public Institution(final String cnpj, final String company, final String city, final Mentor mentor) {
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
	
	public Integer id() {
		return id;
	}
	
	public String cnpj() {
		return cnpj;
	}
	
	public String company() {
		return company;
	}
	
	public String city() {
		return city;
	}
	
	public String mentor() {
		return mentor.name();
	}
	
}
