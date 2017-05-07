/* @(#)InputStreamDeserializer.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.restapi.wrapper.InputStreamWrapper;
/**
 * 
 * A classe {@link InputStreamDeserializer}
 *
 * @author Marcelo
 * @version 1.0 03/11/2016
 */
@Component
public class InputStreamDeserializer extends DefaultJsonDeserializer<InputStreamWrapper> {

	@Override
	protected InputStreamWrapper deserialize(JsonNode node) {
		return new InputStreamWrapper(jsonUtil.getFieldTextValue(node, "base64"));
	}


}
