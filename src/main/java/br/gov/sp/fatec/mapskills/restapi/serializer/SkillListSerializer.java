/*
 * @(#)SkillSerializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.restapi.wrapper.SkillWrapper;

public class SkillListSerializer extends JsonSerializer<SkillWrapper> {

	@Override
	public void serialize(final SkillWrapper arg0, final JsonGenerator arg1, final SerializerProvider arg2)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
