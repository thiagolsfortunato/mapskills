/*
 * @(#)MentorSerializer.java 1.0 31/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;

import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
/**
 * 
 * A classe {@link MentorSerializer} e responsavel
 * por serializar o perfil <i>Mentor</i> da aplicacao.
 *
 * @author Marcelo
 * @version 1.0 31/12/2016
 */
@Component
public class MentorSerializer extends DefaultUserSerializer<Mentor> {
	
	@Autowired
	private InstitutionService service;
	
	@Override
	public void serialize(final Mentor mentor, final JsonGenerator generator) throws IOException {
		generator.writeStartObject();
		serializeDefaultValues(mentor, generator);
		generator.writeStringField("institutionCode", mentor.getInstitutionCode());
		generator.writeNumberField("institutionId", mentor.getInstitutionId());
		generator.writeStringField("institutionLevel", this.getLevel(mentor.getInstitutionCode()));
		generator.writeEndObject();
	}
	
	/**
	 * 
	 * @param institutionCode
	 * @return O nível da instituição que o mentor pertence.
	 */
	private String getLevel(final String institutionCode) {
		return service.findInstitutionByCode(institutionCode).getLevel().name();
	}

}
