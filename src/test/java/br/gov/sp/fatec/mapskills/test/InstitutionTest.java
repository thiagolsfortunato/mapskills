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

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class InstitutionTest implements ApplicationTest {
	
	@Autowired
	InstitutionService service;
	
	@Test
	public void save() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("123456789000", "Jessen Vidal", "S�o Jos�", mentor);
		service.saveInstitution(fatec);
		
		assertEquals(fatec.id(), service.findById(fatec.id()).id());
	}
	
	@Test
	public void saveInstitutions() {
		final List<Institution> list = new ArrayList<>();
		final Mentor mentorA = new Mentor("Mentor Responsavel OURINHOS", "valdez@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("123456789001", "Fatec Ourinhos", "S�o Jos�", mentorA);
		
		final Mentor mentorB = new Mentor("Mentor Responsavel PINDA", "paulo@fatec", "Mudar@123");
		final Institution fatecPINDA = new Institution("123456789002", "Fatec Pinda", "Pindamonhangaba", mentorB);
		
		final Mentor mentorC = new Mentor("Mentor Responsavel SP", "fagundez@fatec", "Mudar@123");
		final Institution fatecSP = new Institution("123456789003", "Fatec SP", "S�o Paulo", mentorC);
		
		list.add(fatecOURINHOS);
		list.add(fatecPINDA);
		list.add(fatecSP);
		service.saveInstitutions(list);
		
		assertEquals(4, service.findAllInstitutions().size());
	}
	
	@Test
	public void saveCourses() {
		final List<Course> coursesList = new ArrayList<>();
		final Course courseA = new Course(1485, "Banco de dados", 1);
		final Course courseB = new Course(1495, "Logistica", 1);
		final Course courseC = new Course(1505, "Estruturas Leves", 1);
		final Course courseD = new Course(1515, "Manuten��o de Aeronaves", 1);
		coursesList.add(courseA);
		coursesList.add(courseB);
		coursesList.add(courseC);
		coursesList.add(courseD);
		
		service.saveCourses(coursesList);
		
		assertEquals(4, service.findAllCourses().size());
	}
	
	@Test
	public void findAllCoursesByInstitution() {
		final List<Course> courses = new ArrayList<>(); 
		courses.addAll(service.findAllCoursesByInstitution(2));
		
		assertEquals(0, courses.size());
	}
	
	@Test
	public void findAllStudentsByCourse() {
		final List<Student> students = new ArrayList<>();
		students.addAll(service.findAllStudentsByCourse(1, 1));
	}
	
	@Test
	public void update() {
		final Institution institution = service.findById(1);
		institution.changeMentorName("Marcos Silveira");
		institution.changeCnpj("71461173000155");
		institution.changeCity("Jacarei");
		institution.changeCompany("Fatec Jacarei");
		service.update(institution);
		
		assertEquals("Marcos Silveira", service.findById(institution.id()).mentor());
	}
	

}