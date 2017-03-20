package br.gov.sp.fatec.mapskills.test.wrapper;

import java.util.Collection;

import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;

public class InstitutionClientWrapper {
	
private long id;
	
	private final String code;
	private final String cnpj;
	private final String company;
	private final InstitutionLevel level;
	private final String city;
	private final Mentor mentor;
	
	public InstitutionClientWrapper(final Institution institution) {
		this.code = institution.getCode();
		this.cnpj = institution.getCnpj();
		this.company = institution.getCompany();
		this.level = institution.getLevel();
		this.city = institution.getCity();
		this.mentor = getMentorFromCollection(institution.getMentors());
	}
	
	private Mentor getMentorFromCollection(final Collection<Mentor> mentors) {
		for(final Mentor mentor : mentors) {
			return mentor;
		}
		return null;
	}

	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCompany() {
		return company;
	}
	
	public InstitutionLevel getLevel() {
		return level;
	}

	public String getCity() {
		return city;
	}

	public Mentor getMentor() {
		return mentor;
	}

}
