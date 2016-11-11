/*
 * @(#)InputStreamWrapper.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.restapi.serializer.InputStreamDeserializer;
import br.gov.sp.fatec.mapskills.utils.Base64Parser;

@JsonDeserialize(using = InputStreamDeserializer.class)
public class InputStreamWrapper {
	
	private Base64Parser parser;
	private final InputStream inputStream;
	private final int institutionId;
	
	public InputStreamWrapper(final String charSequence, final int institutionId) {
		this.inputStream = parser.toInputStream(charSequence);
		this.institutionId = institutionId;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	
	public int getInstitutionId() {
		return institutionId;
	}
	
	@Autowired
	public void setBase64Parser(final Base64Parser base64Parser) {
		this.parser = base64Parser;
	}
	
	

}
