package br.gov.sp.fatec.mapskills.domain.institution;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	public Collection<Course> findAllByInstitutionCode(final int code);

}
