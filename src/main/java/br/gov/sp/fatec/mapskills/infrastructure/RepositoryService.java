/*
 * @(#)PersistenceService.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.infrastructure;
/**
 * Interface responsável por persistir os objetos no banco de dados
 * quem implementa deve declarar o tipo do objeto substituindo o <T> por classe
 *  
 * @author Marcelo
 *
 * @param <T>
 */
public interface RepositoryService<T> {
	
	public T findById(final int id);

}
