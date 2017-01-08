/*
 * @(#)Question.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.scene;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "que_id")
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="que_id")
	private List<Alternative> alternatives;
	
	@Column(name = "ski_id", nullable = false)
	private long skillId;
			
	public Question() {}
	
	public Question(final List<Alternative> alternatives, final long skillId) {
		
		this.alternatives = alternatives;
		this.skillId = skillId;
	}
	
	public long getId() {
		return id;
	}
	
	public long getSkillId() {
		return skillId;
	}
			
	public List<Alternative> getAlternatives() {
		return alternatives;
	}
		
	public void changeAlternatives(final List<Alternative> newAlternatives) {
		final int size = alternatives.size();
		for(int i = 0; i < size; i++) {
			this.alternatives.get(i).changeDescription(newAlternatives.get(i).getDescription());
			this.alternatives.get(i).changeSkillValue(newAlternatives.get(i).getSkillValue());
		}
	}

}
