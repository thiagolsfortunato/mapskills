package br.gov.sp.fatec.mapskills.repository;

public interface Repository {
	
	public void save(final Object arg);
	public void update(final Object arg);
	public void delete(final Object arg);
	public Object findById(final Integer id);
	public void close();

}
