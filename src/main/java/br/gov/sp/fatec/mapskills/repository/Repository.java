package br.gov.sp.fatec.mapskills.repository;

import br.gov.sp.fatec.mapskills.domain.Profile;

public interface Repository {
	
	public void save(final Profile profile);
	public void update(final Profile profile);
	public void delete(final Profile profile);
	public Profile findById(final Integer id);
	public void close();

}
