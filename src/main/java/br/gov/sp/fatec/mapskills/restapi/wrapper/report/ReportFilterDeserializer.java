/*
 * @(#)ReportFilterDeserializer.java 1.0 18/03/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
/**
 * A classe <code>ReportFilterDeserializer</code> e responsavel
 * por deserializar o objeto filtro, para utilizacao das condicionais
 * da query de relatorio.
 * 
 * @author Marcelo
 *
 */
public class ReportFilterDeserializer extends JsonDeserializer<ReportFilter> {

	@Override
	public ReportFilter deserialize(final JsonParser jsonParser, final DeserializationContext arg1)
			throws IOException {
		
		final ObjectCodec oc = jsonParser.getCodec();
        final JsonNode node = oc.readTree(jsonParser);
        
		return new ReportFilter(verifyField(node, "levelInstitution"),
				verifyField(node, "institutionCode"),
				verifyField(node, "courseCode"),
				verifyField(node, "startDate"),
				verifyField(node, "endDate"));
	}
	
	private String verifyField(final JsonNode node, final String field) {
		return node.hasNonNull(field) ? node.get(field).asText() : null;
	}

}
