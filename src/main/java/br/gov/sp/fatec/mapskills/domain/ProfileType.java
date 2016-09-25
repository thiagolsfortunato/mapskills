package br.gov.sp.fatec.mapskills.domain;

/**
 * A enumeração <code>ProfileType</code> contém os tipos de perfis que podem ser
 * assumidos por login da aplicação
 * 
 * @author Marcelo
 *
 */
public enum ProfileType {
	
	UNRATED(0), ADMINISTRATOR(1), MENTOR(2), STUDENT(3);
	
	private final int id;
	
	private ProfileType(final int id) {
		this.id = id;
	}
	
	public int id() {
		return id;
	}


}
