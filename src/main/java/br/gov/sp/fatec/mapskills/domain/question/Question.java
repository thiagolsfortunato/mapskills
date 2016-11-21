/*
 * @(#)Question.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.question;

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
public class Question implements Serializable, Comparable<Question> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "que_id")
	private int id;
	
	@Column(name = "gth_id", nullable = false)
	private int themeId;
	
	@Column(name = "que_index", nullable = false)
	private int index;
	
	@Column(name = "que_description", nullable = false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="que_id")
	private List<Alternative> alternatives;
	
	@Column(name = "ski_id", nullable = false)
	private int skillId;
	
	@Column(name = "que_isActive", nullable = false)
	private boolean enable;
		
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="que_id")
	private List<Text> texts;
	
	public Question() {}
	
	public Question(final String description, final List<Alternative> alternatives, final List<Text> texts,
			final int skillId, final int themeId) {
		
		this.description = description;
		this.alternatives = alternatives;
		this.texts = texts;
		this.skillId = skillId;
		this.themeId = themeId;
		this.enable = true;
	}
	
	public int id() {
		return id;
	}
	
	public int themeId() {
		return themeId;
	}
	
	public int index() {
		return index;
	}
	
	public String description() {
		return description;
	}

	public void putIndex(final int index) {
		this.index = index;
	}
	
	public void changeDescription(final String newDescription) {
		this.description = newDescription;
	}
	
	public void changeAlternatives(final List<Alternative> newAlternatives) {
		final int size = alternatives.size();
		for(int i = 0; i < size; i++) {
			this.alternatives.get(i).changeDescription(newAlternatives.get(i).description());
			this.alternatives.get(i).changeSkillValue(newAlternatives.get(i).skillValue());
		}
	}

	public void enable() {
		this.enable = true;
	}
	
	public void disable() {
		this.enable = false;
	}
	
	public boolean isEnable() {
		return enable;
	}

	/**
	 * O método compareTo é utilizado para realizar a ordenacao das questoes através do index da questão
	 */
	@Override
	public int compareTo(final Question question) {
		return this.index < question.index() ? -1 : (this.index == question.index ? 0 : 1);
	}

}
