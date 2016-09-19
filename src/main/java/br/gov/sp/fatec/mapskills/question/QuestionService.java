package br.gov.sp.fatec.mapskills.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class QuestionService implements PersistenceService<Question> {

	@Autowired(required = true)
	@Qualifier("questionRepository")
	QuestionRepository repository;
	
	@Override
	public void save(final Question obj) {
		repository.save(obj);
	}

	@Override
	public Question findById(Integer id) {
		return repository.findById(id);
	}

}
