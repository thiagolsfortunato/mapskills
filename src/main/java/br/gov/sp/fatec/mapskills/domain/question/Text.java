/*
 * @(#)Text.java 1.0 04/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

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
@Table(name = "question_text")
public class Text {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "txt_id")
	private int id;
	
	@Column(name = "txt_text")
	private String text;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="tmi_id")
	private Multimedia multimedia;
	
	public Text(final String text, final Multimedia multimedia) {
		this.text = text;
		this.multimedia = multimedia;
	}
	
	public int id() {
		return id;
	}
	
	public String text() {
		return text;
	}
	
	public Multimedia multimedia() {
		return multimedia;
	}

}
