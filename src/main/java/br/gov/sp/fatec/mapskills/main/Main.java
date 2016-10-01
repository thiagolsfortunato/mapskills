package br.gov.sp.fatec.mapskills.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
		
		final SkillService service = (SkillService) context.getBean("skillService");
		final Skill skill = service.findById(1);
		System.out.println(String.format("old description: %s", skill.getType()));
		skill.changeType("Resiliencia");
		skill.changeDescription("Breve descrição da habilidade");
		service.create(skill);
		System.out.println(String.format("new description: %s", service.findById(1).getType()));
		

	}

}
