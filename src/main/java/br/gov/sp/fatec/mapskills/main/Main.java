package br.gov.sp.fatec.mapskills.main;

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
		final String ra = "1460281423023";
		System.out.println(ra.length() != 13);
		System.out.println("fatec "+ ra.substring(0, 3));
		System.out.println("curso "+ ra.substring(3, 6));
		System.out.println("ano "+ ra.substring(6, 8));
		System.out.println("semestre "+ ra.substring(8, 9));
		System.out.println("aluno "+ ra.substring(9));
		

	}

}
