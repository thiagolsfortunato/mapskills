package br.gov.sp.fatec.mapskills.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;

public class Main {
	
	public static void main(String[] args) {
		/*@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
		
		final SkillService service = (SkillService) context.getBean("skillService");
		final Skill skill = service.findById(1);
		System.out.println(String.format("old description: %s", skill.getType()));
		skill.changeType("Resiliencia");
		skill.changeDescription("Breve descrição da habilidade");
		service.create(skill);
		System.out.println(String.format("new description: %s", service.findById(1).getType()));*/
		final String ra = "14608020171345";
		System.out.println(ra.length() != 14);
		System.out.println("fatec "+ ra.substring(0, 3));
		System.out.println("curso "+ ra.substring(3, 6));
		System.out.println("ano "+ ra.substring(6, 10));
		System.out.println("semestre "+ ra.substring(10, 11));
		System.out.println("aluno "+ ra.substring(11));
		

	}

}
