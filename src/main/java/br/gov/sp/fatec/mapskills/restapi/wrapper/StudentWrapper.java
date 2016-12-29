package br.gov.sp.fatec.mapskills.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.restapi.serializer.StudentDeserializer;

@JsonDeserialize(using = StudentDeserializer.class)
public class StudentWrapper {
	
	private final Student student;
	
	public StudentWrapper(final Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}

}
