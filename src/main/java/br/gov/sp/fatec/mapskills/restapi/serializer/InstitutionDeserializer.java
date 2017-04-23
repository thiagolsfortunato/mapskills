/* @(#)InstitutionDeserializer.java 1.0 08/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.serializer;

import java.util.Collection;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.JsonNode;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.restapi.wrapper.InstitutionDetailsWrapper;
/**
 * 
 * A classe {@link InstitutionDeserializer} e responsavel
 * por deserializar um instituticao para que seja
 * cadastrada ou atualizada.
 *
 * @author Marcelo
 * @version 1.0 08/01/2017
 */
public class InstitutionDeserializer extends DefaultJsonDeserializer<InstitutionDetailsWrapper> {
	
	private final static String MENTOR = "mentor";
	
	@Override
	protected InstitutionDetailsWrapper deserialize(final JsonNode node) {
		final Collection<Mentor> mentors = new LinkedList<>();
        
        if(node.has(MENTOR)) {
        	mentors.add(this.mentorDeserialize(node.get(MENTOR), jsonUtil.getFieldTextValue(node, "code")));
        } else {
        	mentors.addAll(this.mentorListDeserialize(node.get("mentors"), jsonUtil.getFieldTextValue(node, "code")));
        }
        
		final Institution institution = Institution.builder()
				.code(jsonUtil.getFieldTextValue(node, "code"))
				.cnpj(jsonUtil.getFieldTextValue(node, "cnpj"))
				.company(jsonUtil.getFieldTextValue(node, "company"))
				.city(jsonUtil.getFieldTextValue(node, "city"))
				.level(InstitutionLevel.valueOf(jsonUtil.getFieldTextValue(node, "level")))
				.build();
		
		institution.setId(jsonUtil.getFieldLongValue(node, "id"));
		institution.setMentors(mentors);
		
		return new InstitutionDetailsWrapper(institution);
	}

	private Mentor mentorDeserialize(final JsonNode node, final String institutionCode) {
		final Mentor mentor = Mentor.builder()
				.name(jsonUtil.getFieldTextValue(node, "name"))
				.username(jsonUtil.getFieldTextValue(node, "username"))
				.password(jsonUtil.getFieldPasswordValue(node))
				.institutionCode(institutionCode)
				.build();

        mentor.setId(jsonUtil.getFieldLongValue(node, "id"));
		
        return mentor;
	}
	
	private Collection<Mentor> mentorListDeserialize(final JsonNode node, final String institutionCode) {
		final int sizeArray = node.size();
		final Collection<Mentor> mentors = new LinkedList<>();
		for(int i = 0; i < sizeArray; i++ ) {
			final JsonNode nodeCurrent = node.get(i);
			mentors.add(mentorDeserialize(nodeCurrent, institutionCode));
		}
		return mentors;
	}	

}
