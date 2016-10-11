package br.gov.sp.fatec.mapskills.domain.student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public Student findById(final Integer id);

}
