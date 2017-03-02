/*
 * @(#)StudentsProgressGlobalWrapper.java 1.0 01/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.StudentsProgressGlobalSerializer;

@JsonSerialize(using = StudentsProgressGlobalSerializer.class)
public class StudentsProgressGlobalWrapper {
	
	private final List<Object[]> resultSet = new ArrayList<>();
	
	public StudentsProgressGlobalWrapper(final List<Object[]> resultSet) {
		this.resultSet.clear();
		this.resultSet.addAll(resultSet);
	}
	
	public List<Object[]> getResultSet() {
		return Collections.unmodifiableList(resultSet);
	}

}
