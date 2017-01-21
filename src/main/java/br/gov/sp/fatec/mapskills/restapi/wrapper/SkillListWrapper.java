/*
 * @(#)SkillListWrapper.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.restapi.serializer.SkillListSerializer;

@JsonSerialize(using = SkillListSerializer.class)
public class SkillListWrapper {
	
	private final Collection<Skill> allSkills = new ArrayList<>();
	
	public SkillListWrapper(final Collection<Skill> skills) {
		this.allSkills.addAll(skills);
	}
	
	public Collection<Skill> getAllSkills() {
		return Collections.unmodifiableCollection(allSkills);
	}

}
