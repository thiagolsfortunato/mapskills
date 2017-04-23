/* @(#)InstitutionListSerializer.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionListWrapper;
import br.gov.sp.fatec.mapskills.utils.BeanRetriever;
/**
 * 
 * A classe {@link InstitutionListSerializer} e responsavel
 * por serializar uma lista de instituicao.
 *
 * @author Marcelo
 * @version 1.0 08/01/2017
 */
public class InstitutionListSerializer extends JsonSerializer<InstitutionListWrapper> {
	
	private final DefaultInstitutionSerializer defaultSerializer;
	
	public InstitutionListSerializer() {
		this.defaultSerializer = BeanRetriever.getBean("defaultInstitutionSerializer", DefaultInstitutionSerializer.class);
	}

	@Override
	public void serialize(final InstitutionListWrapper listWrapper, final JsonGenerator generator, final SerializerProvider arg2)
			throws IOException {
		generator.writeStartArray();
		for(final Institution institution : listWrapper.getInstitutions()) {
			defaultSerializer.serialize(institution, generator);
		}
		generator.writeEndArray();
	}

}
