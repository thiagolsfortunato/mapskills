package br.gov.sp.fatec.mapskills.domain.mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class MentorService implements PersistenceService<Mentor> {

	@Autowired(required = true)
	//@Qualifier("mentorRepository")
	MentorRepository repository;

	@Override
	public void create(final Mentor obj) {
		repository.save(obj);
	}

	@Override
	public Mentor findById(final Integer id) {
		return repository.findById(id);
	}
	
}
