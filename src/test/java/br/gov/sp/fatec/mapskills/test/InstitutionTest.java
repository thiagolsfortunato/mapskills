package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import br.gov.sp.fatec.mapskills.config.SpringContextConfiguration;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
import br.gov.sp.fatec.mapskills.domain.institution.InstitutionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContextConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class InstitutionTest implements ApplicationTest{
	
	@Autowired
	InstitutionService service;
	
	@Test
	public void save() {
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123");
		final Institution fatec = new Institution("123456789000", "Jessen Vidal", "São José", mentor);
		service.create(fatec);
		
		assertEquals(mentor.id(), service.findById(fatec.id()).id());
	}
	
	@Test
	public void update() {
		final Institution institution = service.findById(1);
		institution.changeMentorName("Marcos Silveira");
		institution.changeCnpj("71461173000155");
		institution.changeCity("Jacarei");
		institution.changeCompany("Fatec Jacarei");
		service.create(institution);
		
		assertEquals("Marcos Silveira", service.findById(institution.id()).mentor());
	}
	

}
