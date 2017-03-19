/*
 * @(#)StudentResultWrapper.java 1.0 03/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.restapi.serializer.StudentResultSerializer;

/**
 * A classe <code>StudentResultWrapper</code> contem os arrays necessários para
 * renderização do gráfico de radar com o resultado de um aluno.
 *  
 * @author Marcelo
 *
 */
@JsonSerialize(using = StudentResultSerializer.class)
public class StudentResultWrapper {
	
	private final Collection<String> skillsLabels = new LinkedList<>();
	private final Collection<BigDecimal> values = new LinkedList<>();
	private final Collection<Skill> skillsDeatils = new LinkedList<>();
	
	public StudentResultWrapper(final List<Object[]> context) {
		for(final Object[] result : context) {
			this.skillsLabels.add(String.valueOf(result[1]));
			this.values.add((BigDecimal) result[3]);
			this.skillsDeatils.add(new Skill(String.valueOf(result[1]), String.valueOf(result[2])));
		}

	}
	
	public Collection<String> getSkills() {
		return Collections.unmodifiableCollection(skillsLabels);
	}
	
	public Collection<BigDecimal> getValues() {
		return Collections.unmodifiableCollection(values);
	}
	
	public Collection<Skill> getSkillsDeatils() {
		return Collections.unmodifiableCollection(skillsDeatils);
	}

}
