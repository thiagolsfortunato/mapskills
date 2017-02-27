/*
 * @(#)AdministratorTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionLevel;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.domain.user.mentor.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.student.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.student.Student;
import br.gov.sp.fatec.mapskills.test.config.SpringContextTestConfiguration;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextTestConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class AdministratorTest extends MapSkillsTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private InstitutionService institutionService;

	
	@Before
	public void cleanTables() {
		super.cleanTables(institutionService, userService);
	}
	
	@Test
	public void findUserByUsernamePasswords() throws MapSkillsException {
		final String EXPECTED_RA = "Student MockA"; 
		final Collection<Mentor> mentors = new ArrayList<>(1);
		mentors.add(new Mentor("Mentor Responsavel Teste", "146", "marquinhos@fatec.sp.gov.br", "Mudar@123"));
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", InstitutionLevel.SUPERIOR, "São José", mentors);
		institutionService.saveInstitution(fatec);
		
		final Student studentSave = new Student(new AcademicRegistry("2000281423023", "200", "028"), "Student MockA", 
				"1289003400", "studentA@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(studentSave);
		
		final User studentUser = userService.findUserByUsernamePassword("studentA@fatec.sp.gov.br", "mudar@123");
		final User mentorUser = userService.findUserByUsernamePassword("marquinhos@fatec.sp.gov.br", "Mudar@123");
		
		assertEquals(EXPECTED_RA, studentUser.getName());
		assertEquals("Mentor Responsavel Teste", mentorUser.getName());
	}
	
	@Test
	public void saveAdministrator() {
		final Administrator admin = new Administrator("Administrador", "admin", "admin");
		userService.save(admin);
	}


}
