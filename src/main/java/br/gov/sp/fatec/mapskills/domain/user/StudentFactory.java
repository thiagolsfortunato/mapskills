package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.stereotype.Component;

@Component
public class StudentFactory implements UserFactory {

	@Override
	public Student create(final User user) {
		return (Student) user;
	}

}
