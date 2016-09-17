package br.gov.sp.fatec.mapskills.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.mapskills.skill.Skill;
import br.gov.sp.fatec.mapskills.skill.SkillRepository;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		final SkillRepository repo = (SkillRepository) context.getBean("skillRepository");
		final Skill skill = repo.findById(1);
		System.out.println(String.format("old description: %s", skill.description()));
		skill.changeDescription("Resiliencia");
		repo.save(skill);
		System.out.println(String.format("new description: %s", repo.findById(1).description()));
	}

}
