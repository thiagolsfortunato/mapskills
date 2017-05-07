/*
 * @(#)ReportFilterDeserializer.java 1.0 18/03/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.restapi.serializer.DefaultJsonDeserializer;

/**
 * 
 * A classe {@link ReportFilterDeserializer} e responsavel
 * por deserializar o objeto filtro, para utilizacao das condicionais
 * da query de relatorio.
 *
 * @author Marcelo
 * @version 1.0 18/03/2017
 */
public class ReportFilterDeserializer extends DefaultJsonDeserializer<ReportFilter> {

	@Override
	protected ReportFilter deserialize(JsonNode node) {
		return new ReportFilter(jsonUtil.getFieldTextValue(node, "levelInstitution"),
				jsonUtil.getFieldTextValue(node, "institutionCode"),
				jsonUtil.getFieldTextValue(node, "courseCode"),
				jsonUtil.getFieldTextValue(node, "startDate"),
				jsonUtil.getFieldTextValue(node, "endDate"));
	}

}
