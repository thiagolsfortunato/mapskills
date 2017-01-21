/*
 * @(#)Result.java 1.0 05/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

public class Result {
	
	private final String type;
	private final String description;
	private final long value;
	
	public Result(final String type, final String description, final long value) {
		this.type = type;
		this.description = description;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public long getValue() {
		return value;
	}

}
