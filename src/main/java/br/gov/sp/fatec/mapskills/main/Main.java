package br.gov.sp.fatec.mapskills.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Student;

public class Main {
	
	public static void main(String[] args) throws MapSkillsException {
		@SuppressWarnings("resource")
		final ApplicationContext context = new AnnotationConfigApplicationContext(SpringContextConfiguration.class);
		
		final InstitutionService institutionService = (InstitutionService) context.getBean("institutionService");
/*		INSTITUIÇÃO CADASTRADA
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "mentor@fatec", "mudar@123");
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", "São José", mentor);
		institutionService.saveInstitution(fatec);
*/	
		final Course courseA = new Course("028", "Estruturas Leves", CoursePeriod.NOTURNO, "146");
		institutionService.saveCourse(courseA);
		
		final Student studentE = new Student(new AcademicRegistry("1460281423050", "146", "028"), "Student MockE", "1289003400", "studentE@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(studentE);

	}

}
