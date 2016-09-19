package br.gov.sp.fatec.mapskills.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class StudentService implements PersistenceService<Student> {

	@Autowired(required = true)
	@Qualifier("studentRepository")
	StudentRepository repository;
	
	@Override
	public void save(final Student obj) {
		repository.save(obj);
	}

	@Override
	public Student findById(Integer id) {
		return repository.findById(id);
	}

}
