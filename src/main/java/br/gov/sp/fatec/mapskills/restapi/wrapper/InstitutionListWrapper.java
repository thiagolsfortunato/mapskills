package br.gov.sp.fatec.mapskills.restapi.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.restapi.serializer.InstitutionListSerializer;

@JsonSerialize(using = InstitutionListSerializer.class)
public class InstitutionListWrapper {
	
	private final Collection<Institution> institutions = new ArrayList<>();
	
	public InstitutionListWrapper(final Collection<Institution> institutions) {
		this.institutions.addAll(institutions);
	}
	
	public Collection<Institution> getInstitutions() {
		return Collections.unmodifiableCollection(institutions);
	}

}
