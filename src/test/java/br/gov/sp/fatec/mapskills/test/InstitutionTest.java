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

import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.test.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class InstitutionTest {
	
	@Autowired
	private InstitutionService institutionService;
	
	@Test
	public void saveInstitution() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", "São José", mentor);
		institutionService.saveInstitution(fatec);
		
		assertEquals("123456789000", institutionService.findByCode(fatec.getCode()).getCnpj());
	}
	
	@Test
	public void saveInstitutions() {
		final List<Institution> fatecList = new ArrayList<>();
		final Mentor mentorA = new Mentor("Mentor Responsavel OURINHOS", "valdez@fatec", "Mudar@123");
		final Institution fatecOURINHOS = new Institution("147", "123456789001", "Fatec Ourinhos", "São José", mentorA);
		
		final Mentor mentorB = new Mentor("Mentor Responsavel PINDA", "paulo@fatec", "Mudar@123");
		final Institution fatecPINDA = new Institution("148", "123456789002", "Fatec Pinda", "Pindamonhangaba", mentorB);
		
		final Mentor mentorC = new Mentor("Mentor Responsavel SP", "fagundez@fatec", "Mudar@123");
		final Institution fatecSP = new Institution("149", "123456789003", "Fatec SP", "São Paulo", mentorC);
		
		fatecList.add(fatecOURINHOS);
		fatecList.add(fatecPINDA);
		fatecList.add(fatecSP);
		institutionService.saveInstitutions(fatecList);
		
		assertEquals(3, institutionService.findAllInstitutions().size());
	}
	
	@Test
	public void saveAndFindAllCoursesByInstitution() {
		final List<Course> coursesList = new ArrayList<>();
		final Course courseA = new Course("28", "Banco de dados", CoursePeriod.NOTURNO, "146");
		final Course courseB = new Course("29", "Logistica", CoursePeriod.NOTURNO, "146");
		final Course courseC = new Course("30", "Estruturas Leves", CoursePeriod.NOTURNO, "146");
		final Course courseD = new Course("31", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, "146");
		coursesList.add(courseA);
		coursesList.add(courseB);
		coursesList.add(courseC);
		coursesList.add(courseD);
		
		institutionService.saveCourses(coursesList);
		
		assertEquals(4, institutionService.findAllCoursesByInstitution("146").size());
	}
		
	@Test
	public void findAllStudentsByCourseByInstitution() throws MapSkillsException {
		institutionService.saveStudents(mockStudents());
		
		final List<Student> students = new ArrayList<>();
		students.addAll(institutionService.findAllStudentsByCourse("028", "146"));
		
		assertEquals(4, students.size());
	}
	
	@Test
	public void updateInstitution() {
		final Institution institution = institutionService.findByCode("146");
		institution.changeMentorName("Marcos Silveira");
		institution.changeCnpj("71461173000155");
		institution.changeCity("Jacarei");
		institution.changeCompany("Fatec Jacarei");
		institutionService.updateInstitution(institution);
		
		assertEquals("Marcos Silveira", institutionService.findByCode(institution.getCode()).getMentor());
	}
	
	private List<Student> mockStudents() throws MapSkillsException {
		final List<Student> students = new ArrayList<>();
		final Student studentA = new Student(new AcademicRegistry("1460281423023", "146", "028"), "Student MockA", "1289003400", "studentA@fatec.sp.gov.br", "mudar@123");
		final Student studentB = new Student(new AcademicRegistry("1460281423024", "146", "028"), "Student MockB", "1289003500", "studentB@fatec.sp.gov.br", "mudar@123");
		final Student studentC = new Student(new AcademicRegistry("1460281423025", "146", "028"), "Student MockC", "1289003600", "studentC@fatec.sp.gov.br", "mudar@123");
		final Student studentD = new Student(new AcademicRegistry("1460281423026", "146", "028"), "Student MockD", "1289003700", "studentD@fatec.sp.gov.br", "mudar@123");
		students.add(studentA);
		students.add(studentB);
		students.add(studentC);
		students.add(studentD);
		return students;
	}
	

}
