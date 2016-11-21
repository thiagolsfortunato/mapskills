/*
 * @(#)GameTheme.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.theme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game_theme")
public class GameTheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gth_id")
	private int id;
	
	@Column(name = "gth_description", nullable = false)
	private String description;
	
	//private List<Integer> questions; 
	
	@Column(name = "gth_isActive", nullable = false)
	private boolean active = false;
	
	public GameTheme() {}
	
	public GameTheme(final String description) {
		this.description = description;
	}
	
	public int id() {
		return id;
	}
	
	public String description() {
		return description;
	}
	
	public void off() {
		active = false;
	}
	
	public void on() {
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

}
