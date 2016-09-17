package br.gov.sp.fatec.mapskills.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.mapskills.skill.Skill;
import br.gov.sp.fatec.mapskills.skill.SkillService;
import br.gov.sp.fatec.mapskills.spring.SpringRootConfig;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		
		final SkillService service = (SkillService) context.getBean("skillService");
		final Skill skill = service.findById(1);
		System.out.println(String.format("old description: %s", skill.description()));
		skill.changeDescription("Resiliencia");
		service.save(skill);
		System.out.println(String.format("new description: %s", service.findById(1).description()));
	}

}
