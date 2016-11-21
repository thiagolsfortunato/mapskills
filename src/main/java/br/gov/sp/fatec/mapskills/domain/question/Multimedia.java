/*
 * @(#)Multimedia.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "text_midia")
public class Multimedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid_id")
	private int id;
	
	@Column(name = "mid_url")
	private String url;
	
	public Multimedia() {}
	
	public Multimedia(final String url) {
		this.url = url;
	}
	
	public int id() {
		return id;
	}
	
	public String url() {
		return url;
	}

}
