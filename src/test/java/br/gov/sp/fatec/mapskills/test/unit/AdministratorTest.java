/*
 * @(#)AdministratorTest.java 1.0 29/12/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.unit;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.user.AcademicRegistry;
import br.gov.sp.fatec.mapskills.domain.user.Administrator;
import br.gov.sp.fatec.mapskills.domain.user.ProfileType;
import br.gov.sp.fatec.mapskills.domain.user.Student;
import br.gov.sp.fatec.mapskills.domain.user.User;
import br.gov.sp.fatec.mapskills.domain.user.UserFactory;
import br.gov.sp.fatec.mapskills.domain.user.UserService;
import br.gov.sp.fatec.mapskills.test.unit.config.SpringContextConfigurationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfigurationTest.class, loader = AnnotationConfigContextLoader.class)
public class AdministratorTest extends MapSkillsTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private InstitutionService institutionService;
	
	@Resource
	private Map<ProfileType, UserFactory> userFactory;
	
	@After
	public void cleanTables() {
		super.cleanTables(institutionService, userService);
	}
	
	@Test
	public void findUserByUsernamePasswords() throws MapSkillsException {
		final String EXPECTED_RA = "2000281423023"; 
		
		final Mentor mentorSave = new Mentor("Mentor Responsavel Teste", "146", "marquinhos@fatec.sp.gov.br", "Mudar@123");
		final Institution fatec = new Institution("146", "123456789000", "Jessen Vidal", "São José", mentorSave);
		institutionService.saveInstitution(fatec);
		
		final Student studentSave = new Student(new AcademicRegistry("2000281423023", "200", "028"), "Student MockA", "1289003400", "studentA@fatec.sp.gov.br", "mudar@123");
		institutionService.saveStudent(studentSave);
		
		final User studentUser = userService.findUserByUsernamePassword("studentA@fatec.sp.gov.br", "mudar@123");
		final User mentorUser = userService.findUserByUsernamePassword("marquinhos@fatec.sp.gov.br", "Mudar@123");
		
		final Student student = userFactory.get(studentUser.getProfile()).create(studentUser);
		final Mentor mentor = userFactory.get(mentorUser.getProfile()).create(mentorUser);
		
		assertEquals(EXPECTED_RA, student.getRa());
		assertEquals("Mentor Responsavel Teste", mentor.getName());
	}
	
	@Test
	public void saveAdministrator() {
		final Administrator admin = new Administrator("Administrador", "admin", "admin");
		userService.save(admin);
	}


}
