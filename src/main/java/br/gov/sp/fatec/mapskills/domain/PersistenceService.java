package br.gov.sp.fatec.mapskills.domain;
/**
 * interface responsável por persistir os objetos no banco de dados
 * quem implementa deve declarar o tipo do objeto substituindo o <T> por classe
 *  
 * @author Marcelo
 *
 * @param <T>
 */
public interface PersistenceService<T> {
	
	public void create(final T obj);
	public T findById(final Integer id);

}
