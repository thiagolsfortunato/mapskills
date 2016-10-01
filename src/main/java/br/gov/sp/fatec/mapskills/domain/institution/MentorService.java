package br.gov.sp.fatec.mapskills.domain.institution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class MentorService implements PersistenceService<Mentor> {
	
	@Autowired(required = true)
	@Qualifier("mentorRepository")
	private MentorRepository repository;

	public void create(final Mentor obj) {
		repository.save(obj);
	}

	public Mentor findById(final Integer id) {
		return repository.findById(id);
	}

	
}