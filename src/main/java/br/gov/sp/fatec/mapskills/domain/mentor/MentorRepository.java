package br.gov.sp.fatec.mapskills.domain.mentor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends CrudRepository<Mentor, Integer> {
	
	public Mentor findById(final Integer id);


}
