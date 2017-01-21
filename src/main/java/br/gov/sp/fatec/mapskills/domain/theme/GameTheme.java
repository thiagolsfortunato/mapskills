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
	private long id;
	
	@Column(name = "gth_description", nullable = false)
	private String description;
		
	@Column(name = "gth_is_active", nullable = false)
	private boolean active = false;
	
	public GameTheme() {
		// CONSTRUCTOR DEFAULT
	}
	
	public GameTheme(final String description) {
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(final long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void disable() {
		active = false;
	}
	
	public void enable() {
		active = true;
	}
	
	public boolean isActive() {
		return active;
	}

}
