package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfigurationTest;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class InstitutionTest implements ApplicationTest {
	
	@Autowired
	InstitutionService service;
	
	@Test
	public void test() {
		assertEquals(4, 2 + 2);
	}
	
	@Test
	public void saveInstitution() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution(146, "123456789000", "Jessen Vidal", "São José", mentor);
		service.saveInstitution(fatec);
		
		assertEquals(fatec.code(), service.findByCode(fatec.code()).code());
	}
	
	@Test
	public void saveInstitutions() {
		final List<Institution> list = new ArrayList<>();
		final Mentor mentorA = new Mentor("Mentor Responsavel OURINHOS", "valdez@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution(147, "123456789001", "Fatec Ourinhos", "São José", mentorA);
		
		final Mentor mentorB = new Mentor("Mentor Responsavel PINDA", "paulo@fatec", "Mudar@123");
		final Institution fatecPINDA = new Institution(148, "123456789002", "Fatec Pinda", "Pindamonhangaba", mentorB);
		
		final Mentor mentorC = new Mentor("Mentor Responsavel SP", "fagundez@fatec", "Mudar@123");
		final Institution fatecSP = new Institution(149, "123456789003", "Fatec SP", "São Paulo", mentorC);
		
		list.add(fatecOURINHOS);
		list.add(fatecPINDA);
		list.add(fatecSP);
		service.saveInstitutions(list);
		
		assertEquals(3, service.findAllInstitutions().size());
	}
	
	@Test
	public void saveCourses() {
		final List<Course> coursesList = new ArrayList<>();
		final Course courseA = new Course(28, "Banco de dados", 146);
		final Course courseB = new Course(29, "Logistica", 146);
		final Course courseC = new Course(30, "Estruturas Leves", 146);
		final Course courseD = new Course(31, "Manutenção de Aeronaves", 146);
		coursesList.add(courseA);
		coursesList.add(courseB);
		coursesList.add(courseC);
		coursesList.add(courseD);
		
		service.saveCourses(coursesList);
		
		assertEquals(4, service.findAllCourses().size());
	}
	
	@Test
	public void findAllCoursesByInstitution() {
		service.saveCourse(new Course(28, "Banco de dados", 146));
		
		final List<Course> courses = new ArrayList<>(); 
		courses.addAll(service.findAllCoursesByInstitution(146));
		
		assertEquals(1, courses.size());
	}
	
	@Test
	public void findAllStudentsByCourse() {
		final List<Student> students = new ArrayList<>();
		students.addAll(service.findAllStudentsByCourse(1495, 1));
		
		assertEquals(1, students.size());
	}
	
	@Test
	public void update() {
		final Institution institution = service.findByCode(146);
		institution.changeMentorName("Marcos Silveira");
		institution.changeCnpj("71461173000155");
		institution.changeCity("Jacarei");
		institution.changeCompany("Fatec Jacarei");
		service.updateInstitution(institution);
		
		assertEquals("Marcos Silveira", service.findByCode(institution.code()).mentor());
	}
	

}
