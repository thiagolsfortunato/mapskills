package br.gov.sp.fatec.mapskills.domain;

public interface Profile {
	
	public Integer id();
	public String name();
	public void changeName(final String newName);

}
