package br.gov.sp.fatec.mapskills.domain.user;

import org.springframework.stereotype.Component;

@Component
public class AdministratorFactory implements UserFactory {

	@Override
	public Administrator create(final User user) {
		return (Administrator) user;
	}

}
