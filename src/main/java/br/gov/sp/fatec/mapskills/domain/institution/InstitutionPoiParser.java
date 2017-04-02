/* @(#)InstitutionPoiParser.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.utils.PoiParser;
/**
 * A classe <code>InstitutionXLSXParser</code> converte um arquivo .xlsx em objetos do tipo Mentor
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
@Component
public class InstitutionPoiParser extends PoiParser<Institution> {
	
	private static final int DATA_NUMBER = 7;
	
	@Autowired
	private InstitutionService service;
	
	@Override
	public List<Institution> toObjectList(final InputStream inputStream) throws MapSkillsException {
		return Collections.unmodifiableList(super.objectListFactory(inputStream));
	}

	@Override
	protected Institution buildObject(final List<String> attArgs) throws MapSkillsException {
		final Collection<Mentor> mentors = new HashSet<>();
		final Institution institution = service.findInstitutionByCnpj(attArgs.get(1));
		if(institution == null) {
			mentors.add(new Mentor(attArgs.get(5), attArgs.get(0), attArgs.get(6), ENCRYPTED_DEFAULT_PASSWORD));
			return new Institution(attArgs.get(0), attArgs.get(1), attArgs.get(2), 
					InstitutionLevel.build(attArgs.get(3).toUpperCase()), attArgs.get(4), mentors);
		} else {
			return this.updateInstitution(institution, mentors, attArgs);
		}
	}

	@Override
	protected boolean verifyListForObject(final List<String> argsToObj) {
		return argsToObj.size() == DATA_NUMBER;
	}
	
	private Institution updateInstitution(final Institution institution, final Collection<Mentor> mentors,
			final List<String> attArgs) {
		
		mentors.add(this.updateMentor(attArgs));
		return new Institution(institution.getId(), attArgs.get(0), attArgs.get(1), attArgs.get(2), 
				InstitutionLevel.build(attArgs.get(3).toUpperCase()), attArgs.get(4), mentors, institution.getThemeId());
	}
	
	private Mentor updateMentor(final List<String> attArgs) {
		Mentor mentor = service.findMentorByUsername(attArgs.get(6));
		if(mentor == null) {
			return new Mentor(attArgs.get(5), attArgs.get(0), attArgs.get(6), ENCRYPTED_DEFAULT_PASSWORD);
		} else {
			return new Mentor(mentor.getId(), attArgs.get(5), mentor.getInstitutionId(), attArgs.get(0), attArgs.get(6), ENCRYPTED_DEFAULT_PASSWORD);
		}
	}

}
