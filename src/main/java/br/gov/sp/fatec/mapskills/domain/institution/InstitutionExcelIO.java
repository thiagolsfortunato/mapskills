/* @(#)InstitutionPoiParser.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.utils.AbstractExcelIO;
/**
 * A classe <code>InstitutionXLSXParser</code> converte um arquivo .xlsx em objetos do tipo Mentor
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
@Component
public class InstitutionExcelIO extends AbstractExcelIO<Institution> {
	
	private static final int DATA_NUMBER = 7;
	
	@Autowired
	private InstitutionService service;
	
	@Override
	public List<Institution> toObjectList(final InputStream inputStream) throws MapSkillsException {
		return Collections.unmodifiableList(super.objectListFactory(inputStream));
	}

	@Override
	protected Institution buildObject(final List<String> attArgs) throws MapSkillsException {		
		
		final Institution institutionExcel = Institution.builder()
				.code(attArgs.get(0))
				.cnpj(attArgs.get(1))
				.company(attArgs.get(2))
				.level(InstitutionLevel.build(attArgs.get(3).toUpperCase()))
				.city(attArgs.get(4))
				.build();
		
		final Institution institution = service.findInstitutionByCnpj(attArgs.get(1));
		if(institution != null) {
			institutionExcel.setId(institution.getId());
			institutionExcel.setGameThemeId(institution.getGameThemeId());
		}
		institutionExcel.addMentor(this.buildMentor(attArgs));

		return institutionExcel;
	}

	@Override
	protected boolean verifyListForObject(final List<String> argsToObj) {
		return argsToObj.size() == DATA_NUMBER;
	}
	
	private Mentor buildMentor(final List<String> attArgs) {
		final Mentor mentor = service.findMentorByUsername(attArgs.get(6));
		final Mentor mentorExcel = Mentor.builder()
				.name(attArgs.get(5))
				.institutionCode(attArgs.get(0))
				.username(attArgs.get(6))
				.password(AbstractExcelIO.DEFAULT_ENCRYPTED_PASS)
				.build();
		if(mentor != null) {
			mentorExcel.setId(mentor.getId());
		}
		return mentorExcel;
	}

}
