package br.gov.sp.fatec.mapskills.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.gov.sp.fatec.mapskills.domain.Question;

public class QuestionRepository implements Repository {
	
	final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapskills");
	final EntityManager manager = factory.createEntityManager();

	public void save(final Object question) {
		manager.getTransaction().begin();
		manager.persist(question);
		manager.getTransaction().commit();

	}

	public void update(final Object question) {
		manager.getTransaction().begin();
		manager.merge(question);
		manager.getTransaction().commit();

	}

	public void delete(final Object question) {
		manager.getTransaction().begin();
		manager.remove(question);
		manager.getTransaction().commit();

	}

	public Question findById(final Integer id) {
		return manager.find(Question.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> questionList() {
		final String queryText = "SELECT q FROM Question q ORDER BY q.index";
		final Query query = manager.createQuery(queryText);
		final List<Question> questions = query.getResultList();
		return questions;
	}

	public void close() {
		manager.close();
		factory.close();

	}

}
