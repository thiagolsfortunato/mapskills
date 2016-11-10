package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.domain.institution.Mentor;

@Component
public class MentorFactory implements UserFactory {

	@Override
	public Mentor create(User user) {
		return (Mentor) user;
	}

}
