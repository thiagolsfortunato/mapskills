/*
 * @(#)Question.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.scene;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "que_id")
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="que_id")
	private Collection<Alternative> alternatives = new ArrayList<>(4);
	
	@Column(name = "ski_id", nullable = false)
	private long skillId;
			
	public Question() {
		// CONSTRUCTOR DEFAULT
	}
	
	public Question(final Collection<Alternative> alternatives, final long skillId) {
		this.alternatives.addAll(alternatives);
		this.skillId = skillId;
	}
	
	public void setId(final long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public long getSkillId() {
		return skillId;
	}
			
	public Collection<Alternative> getAlternatives() {
		return Collections.unmodifiableCollection(alternatives);
	}


}
