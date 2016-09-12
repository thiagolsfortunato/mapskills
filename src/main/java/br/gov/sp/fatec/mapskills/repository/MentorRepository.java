package br.gov.sp.fatec.mapskills.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.sp.fatec.mapskills.domain.Mentor;

public class MentorRepository implements Repository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapskills");
	EntityManager manager = factory.createEntityManager();

	public void save(final Object profile) {
		manager.getTransaction().begin();
		manager.persist(profile);
		manager.getTransaction().commit();

	}

	public void update(final Object profile) {
		manager.getTransaction().begin();
		manager.merge(profile);
		manager.getTransaction().commit();

	}

	public void delete(final Object profile) {
		manager.getTransaction().begin();
		manager.remove(profile);
		manager.getTransaction().commit();

	}

	public Mentor findById(final Integer id) {
		return manager.find(Mentor.class, id);
	}

	public void close() {
		manager.close();
		factory.close();

	}

}
