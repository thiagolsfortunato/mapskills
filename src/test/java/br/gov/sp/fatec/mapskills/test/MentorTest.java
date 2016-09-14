package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.mapskills.mentor.Institution;
import br.gov.sp.fatec.mapskills.mentor.Mentor;
import br.gov.sp.fatec.mapskills.mentor.MentorRepository;

public class MentorTest implements ApplicationTest{
	
	@Autowired
	MentorRepository repository;
	
	@Test
	@Transactional
	public void save() {
		final Institution fatec = new Institution("83237522000139", "Jessen Vidal", "S�o Jos�");
		final Mentor mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123", fatec);
		repository.save(mentor);
		
		
		assertEquals(mentor.id(), repository.findById(mentor.id()).id());
	}
	
	@Test
	@Transactional
	public void update() {
		final Mentor mentor = repository.findById(2);
		mentor.setName("Marcos Silveira");
		mentor.changeInstitution(new Institution("71461173000155","Fatec Jacarei","Jacarei"));
		repository.save(mentor);
		
		assertEquals("Marcos Silveira", repository.findById(mentor.id()).name());
	}
	
	@Test
	@Transactional
	public void delete() {
		final Mentor mentor = repository.findById(1);
		repository.delete(mentor);

		Assert.assertNull(repository.findById(1));
	}

}
