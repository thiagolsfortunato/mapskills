/*
 * @(#)InstitutionSerializerStrategy.java 1.0 07/01/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
/**
 * 
 * A interface {@link InstitutionSerializerStrategy} representa
 * abstracao de serializacao de uma instituticao.
 *
 * @author Marcelo
 * @version 1.0 07/01/2017
 */
@FunctionalInterface
public interface InstitutionSerializerStrategy {
	
	public void serialize(final Institution institution, final JsonGenerator generator) throws IOException;

}
