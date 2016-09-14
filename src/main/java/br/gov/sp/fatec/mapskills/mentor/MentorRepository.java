package br.gov.sp.fatec.mapskills.mentor;

import org.springframework.data.repository.CrudRepository;

public interface MentorRepository extends CrudRepository<Mentor, Integer> {
	
	public Mentor findById(final Integer id);


}
