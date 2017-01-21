/*
 * @(#)StudentResultWrapper.java 1.0 03/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 * A classe <code>StudentResultWrapper</code> contem os arrays necessários para
 * renderização do gráfico de radar com o resultado de um aluno.
 *  
 * @author Marcelo
 *
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.StudentResultSerializer;
@JsonSerialize(using = StudentResultSerializer.class)
public class StudentResultWrapper {
	
	private final Collection<String> skills = new ArrayList<>();
	private final Collection<Integer> values = new ArrayList<>();
	
	public StudentResultWrapper(final List<Object[]> context) {
		for(final Object[] result : context) {
			this.skills.add(String.valueOf(result[0]));
			this.values.add((Integer) result[1]);
		}
	}
	
	public Collection<String> getSkills() {
		return Collections.unmodifiableCollection(skills);
	}
	
	public Collection<Integer> getValues() {
		return Collections.unmodifiableCollection(values);
	}

}
