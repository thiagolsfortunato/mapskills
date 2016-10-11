package br.gov.sp.fatec.mapskills.domain.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.PersistenceService;

@Service
public class StudentService implements PersistenceService<Student> {

	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository repository;
	
	public void create(final Student student) {
		repository.save(student);
	}

	public void create(final List<Student> students) {
		repository.save(students);
	}
	
	public Student findById(final Integer id) {
		return repository.findById(id);
	}
	
}
