package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.restapi.serializer.InstitutionDeserializer;

@JsonDeserialize(using = InstitutionDeserializer.class)
public class InstitutionWrapper {
	
	private final Institution institution;
	
	public InstitutionWrapper(final Institution institution) {
		this.institution = institution;
	}
	
	public Institution getInstitution() {
		return institution;
	}

}
