package br.gov.sp.fatec.mapskills.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.gov.sp.fatec.mapskills.domain.Skill;

public class SkillRepository implements Repository {
	
	final EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapskills");
	final EntityManager manager = factory.createEntityManager();
	
	public void save(final Object skill) {
		manager.getTransaction().begin();
		manager.persist(skill);
		manager.getTransaction().commit();
		
	}

	public void update(final Object skill) {
		manager.getTransaction().begin();
		manager.merge(skill);
		manager.getTransaction().commit();
		
	}

	public void delete(final Object skill) {
		manager.getTransaction().begin();
		manager.remove(skill);
		manager.getTransaction().commit();
		
	}

	public Skill findById(final Integer id) {
		return manager.find(Skill.class, id);
	}

	public void close() {
		manager.close();
		factory.close();
		
	}

}
