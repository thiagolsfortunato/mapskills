package br.gov.sp.fatec.mapskills.test;

import br.gov.sp.fatec.mapskills.infrastructure.RepositoryService;

public abstract class MapSkillsTest {
	
	protected void cleanTables(final RepositoryService<?>... services) {
		for(final RepositoryService<?> service : services) {
			final String serviceName = service.getClass().getSimpleName();
			System.err.println("limpando dados da tabela " + serviceName.replace("Service", "").toUpperCase());
			service.deleteAll();
		}
	}

}
