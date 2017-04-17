/*
 * @(#)InstitutionTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Course;
import br.gov.sp.fatec.mapskills.domain.institution.CoursePeriod;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;

public class InstitutionTest extends MapSkillsTest {
	
	@Autowired
	private InstitutionService institutionService;
	
	@After
	public void cleanTables() {
		super.cleanTables(institutionService);
	}
	
	@Test
	public void saveInstitution() {
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", InstitutionLevel.SUPERIOR, "São José");
		fatec.addMentor(new Mentor("Mentor Responsavel Teste", "146", "marquinhos@fatec", "Mudar@123"));
		institutionService.saveInstitution(fatec);
		
		assertEquals("123456789000", institutionService.findInstitutionById(fatec.getId()).getCnpj());
	}
	
	@Test
	public void findInstitutionDetails() throws MapSkillsException {
		final Institution fatec = new Institution("147", "123456789000", "Jessen Vidal", InstitutionLevel.SUPERIOR, "São José");
		fatec.addMentor(new Mentor("Mentor Responsavel Teste", "147", "marquinhos@fatec", "Mudar@123"));
		institutionService.saveInstitution(fatec);
		
		final List<Course> coursesList = new ArrayList<>(4);
		coursesList.add(new Course("28", "Banco de dados", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("29", "Logistica", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("30", "Estruturas Leves", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("31", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, "147"));
		institutionService.saveCourses(coursesList);
		
		final Institution institutionDetails = institutionService.findInstitutionDetailsById(fatec.getId());
		assertEquals(4, institutionDetails.getCourses().size());
	}
	
	@Test
	public void saveInstitutions() {
		final List<Institution> fatecList = new ArrayList<>(3);

		final Institution fatecOURINHOS = new Institution("147", "123456789001", "Fatec Ourinhos", InstitutionLevel.SUPERIOR, "São José");
		fatecOURINHOS.addMentor(new Mentor("Mentor Responsavel OURINHOS", "147", "valdez@fatec", "Mudar@123"));
		
		final Institution fatecPINDA = new Institution("148", "123456789002", "Fatec Pinda", InstitutionLevel.SUPERIOR, "Pindamonhangaba");
		fatecPINDA.addMentor(new Mentor("Mentor Responsavel PINDA", "148", "paulo@fatec", "Mudar@123"));
		
		final Institution fatecSP = new Institution("149", "123456789003", "Fatec SP", InstitutionLevel.SUPERIOR, "São Paulo");
		fatecSP.addMentor(new Mentor("Mentor Responsavel SP", "149", "fagundez@fatec", "Mudar@123"));
		
		fatecList.add(fatecOURINHOS);
		fatecList.add(fatecPINDA);
		fatecList.add(fatecSP);
		
		institutionService.saveInstitutions(fatecList);
		
		assertEquals(3, institutionService.findAllInstitutions().size());
	}
	
	@Test
	public void saveAndFindAllCoursesByInstitution() {
		final List<Course> coursesList = new ArrayList<>(4);

		final Institution fatecOURINHOS = new Institution("147", "123456789001", "Fatec Ourinhos", InstitutionLevel.SUPERIOR, "Ouro Preto");
		fatecOURINHOS.addMentor(new Mentor("Mentor Responsavel OURINHOS", "147", "valdez@fatec", "Mudar@123"));
		institutionService.saveInstitution(fatecOURINHOS);

		coursesList.add(new Course("28", "Banco de dados", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("29", "Logistica", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("30", "Estruturas Leves", CoursePeriod.NOTURNO, "147"));
		coursesList.add(new Course("31", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, "147"));
		
		institutionService.saveCourses(coursesList);
		
		assertEquals(4, institutionService.findAllCoursesByInstitutionCode("147").size());
	}
		
	@Test
	public void findAllStudentsByCourseAndInstitution() throws MapSkillsException {
		institutionService.saveStudents(mockStudents());
		final Student studentE = new Student(new AcademicRegistry("1460281423050", "146", "028"), "Student MockE",
				"1289003400", "studentE@fatec.sp.gov.br", "mudar@123");
		final Student studentF = new Student(new AcademicRegistry("1460281423073", "146", "038"), "Student MockF", 
				"1289003400", "studentF@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(studentE);
		institutionService.saveStudent(studentF);
		
		final List<Student> students = new ArrayList<>();
		students.addAll(institutionService.findAllStudentsByCourseAndInstitution("028", "146"));
		
		assertEquals(5, students.size());
	}
	
	@Test
	public void updateInstitution() {

		final Institution fatecOURINHOS = new Institution("200", "123456909001", "Fatec Ourinhos", InstitutionLevel.SUPERIOR, "Ourinhos");
		fatecOURINHOS.addMentor(new Mentor("Victor Responsavel OURINHOS", "200", "victor@fatec", "Mudar@123"));
		
		final Institution fatecSAMPA = new Institution("156", "123445789001", "Fatec Sampa", InstitutionLevel.SUPERIOR, "São Paulo");
		fatecSAMPA.addMentor(new Mentor("Regina", "156", "regina@fatec", "Mudar@123"));
		final List<Institution> institutions = new ArrayList<>(2);
		institutions.add(fatecSAMPA);
		institutions.add(fatecOURINHOS);
		institutionService.saveInstitutions(institutions);
		
		final Institution institution = institutionService.findInstitutionById(fatecSAMPA.getId());
		institution.setCnpj("71461173000155");
		institution.setCity("Jacarei");
		institution.setCompany("Fatec Jacarei");
		institutionService.saveInstitution(institution);
		
		assertEquals("Fatec Jacarei", institutionService.findInstitutionById(institution.getId()).getCompany());
	}
	
	@Test
	public void saveCourses() throws MapSkillsException {
		final Institution fatecOURINHOS = new Institution("144", "123456909001", "Fatec Ourinhos", InstitutionLevel.SUPERIOR, "Ourinhos");
		fatecOURINHOS.addMentor(new Mentor("Victor Responsavel OURINHOS", "144", "victor@fatec", "Mudar@123"));
		institutionService.saveInstitution(fatecOURINHOS);

		final List<Course> courses = new ArrayList<>(3);
		courses.add(new Course("200", "Estruturas Leves", CoursePeriod.NOTURNO, "144"));
		courses.add(new Course("201", "Manutenção de Aeronaves", CoursePeriod.NOTURNO, "144"));
		courses.add(new Course("202", "Logistica", CoursePeriod.NOTURNO, "144"));
		institutionService.saveCourses(courses);
		
		assertEquals(3, institutionService.findAllCoursesByInstitutionCode("144").size());
	}
	
	@Test
	public void saveThemeInstitution() {
		final Institution fatecOURINHOS = new Institution("144", "123456909001", "Fatec Ourinhos", InstitutionLevel.SUPERIOR, "Ourinhos");
		fatecOURINHOS.addMentor(new Mentor("Victor Responsavel OURINHOS", "144", "victor@fatec", "Mudar@123"));
		institutionService.saveInstitution(fatecOURINHOS);
		
		assertEquals(0, institutionService.findInstitutionById(fatecOURINHOS.getId()).getGameThemeId());
		
		fatecOURINHOS.setGameThemeId(1);
		institutionService.saveInstitution(fatecOURINHOS);
		
		assertEquals(1, institutionService.findInstitutionById(fatecOURINHOS.getId()).getGameThemeId());
	}
	
	private List<Student> mockStudents() throws MapSkillsException {
		final List<Student> students = new ArrayList<>();
		students.add(new Student(new AcademicRegistry("1460281423023", "146", "028"), "Student MockA", "1289003400",
				"studentA@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423024", "146", "028"), "Student MockB", "1289003500",
				"studentB@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423025", "146", "028"), "Student MockC", "1289003600",
				"studentC@fatec.sp.gov.br", "mudar@123"));
		students.add(new Student(new AcademicRegistry("1460281423026", "146", "028"), "Student MockD", "1289003700",
				"studentD@fatec.sp.gov.br", "mudar@123"));
		return students;
	}
	

}
