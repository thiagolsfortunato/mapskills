/*
 * @(#)PersistenceService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.infrastructure;

/**
 * 
 * A interface {@link RepositoryService} contem a assinatura de metodo
 * que todas as classes que a implementam devem implemetar. Utilizado
 * nos testes para limpar as tabelas da base de dados, para que um
 * escopo de teste nao interfira no outro.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
@FunctionalInterface
public interface RepositoryService {
	public void deleteAll();
}
