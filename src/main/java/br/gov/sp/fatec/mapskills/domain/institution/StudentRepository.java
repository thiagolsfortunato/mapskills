package br.gov.sp.fatec.mapskills.domain.institution;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.mapskills.domain.user.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	//@Query("SELECT s FROM Student s INNER JOIN Institution i ON i.code = s.ra.institutionCode WHERE i.code = ?1")
	//@Query("SELECT s FROM Student s WHERE s.ra.institutionCode = ?1")
	//public Student findStudentByAcademicRegistryRa(final String ra);
	
	public List<Student> findAll();

}
