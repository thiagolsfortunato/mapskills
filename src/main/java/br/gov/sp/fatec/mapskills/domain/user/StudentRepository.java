package br.gov.sp.fatec.mapskills.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	//@Query("SELECT s FROM Student s INNER JOIN Institution i ON i.code = s.ra.institutionCode WHERE i.code = ?1")
	//@Query("SELECT s FROM Student s WHERE s.ra.institutionCode = ?1")
	//public Student findStudentByAcademicRegistryRa(final String ra);
	@Query("SELECT s FROM Student s INNER JOIN Course c ON s.courseCode() = c.code "
			+ "INNER JOIN Institution i ON c.institutionCode = i.code WHERE c.code = ?1 AND i.code = ?2")
	public List<Student> findAllByCourseAndInstitution(final String courseCode, final String institutionCode);
	
	public List<Student> findAll();
	
	public Student findByRaRa(final String ra); 
	
	public List<Student> findAllByRaInstitutionCode(final String institutionCode);

}
