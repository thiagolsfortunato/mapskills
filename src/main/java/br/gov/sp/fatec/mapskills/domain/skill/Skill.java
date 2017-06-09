/*
 * @(#)Skill.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.skill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
/**
 * 
 * A classe {@link Skill} representa uma competencia
 * que o aluno pode conter no contexto da aplicacao.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SKILL")
public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ski_id")
	private long id;
	
	@Column(name = "ski_type", nullable = false)
	private String type;
	
	@Column(name = "ski_description")
	private String description;
	
	public Skill() {
		// CONSTRUCTOR DEFAULT
	}
	
	public void changeType(final String newType) {
		this.type = newType;
	}
	
	public void changeDescription(final String newDescription) {
		this.description = newDescription;
	}
	
	public void setId(final long id) {
		this.id = id;
	}

}
