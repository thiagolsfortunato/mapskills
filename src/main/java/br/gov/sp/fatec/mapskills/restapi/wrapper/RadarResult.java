/*
 * @(#)RadarResult.java 1.0 05/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;

public class RadarResult {
	
	private long userId;
	private final Skill skill;
	private final int value;
	
	public RadarResult(final Skill skill, final int value) {
		this.skill = skill;
		this.value = value;
	}
	
	public long getUserId() {
		return userId;
	}

	public String getSkill() {
		return skill.getType();
	}

	public int getValue() {
		return value;
	}
	
	public String getSkillDescription() {
		return skill.getDescription();
	}

}
