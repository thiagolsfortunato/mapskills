package br.gov.sp.fatec.mapskills.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.ra.courseCode = ?1 AND s.ra.institutionCode = ?2")
	public List<Student> findAllByCourseAndInstitution(final String courseCode, final String institutionCode);
	
	public List<Student> findAll();
	
	public Student findByRaRa(final String ra); 
	
	public List<Student> findAllByRaInstitutionCode(final String institutionCode);

}
