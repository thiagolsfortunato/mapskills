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
	private long id;
	
	@Column(name = "mid_url")
	private String url;
	
	public Multimedia() {}
	
	public Multimedia(final String url) {
		this.url = url;
	}
	
	public long getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void changeUrl(final String newUrl) {
		url = newUrl;
	}

}
