package br.gov.sp.fatec.mapskills.domain.user;

public class RAInvalidException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	
	private final String ra;
	
	public RAInvalidException(final String ra) {
		this.ra = ra;
	}
	
	public String ra() {
		return ra;
	}

}
