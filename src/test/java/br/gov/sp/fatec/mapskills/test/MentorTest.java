package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.mapskills.domain.Institution;
import br.gov.sp.fatec.mapskills.domain.Mentor;
import br.gov.sp.fatec.mapskills.domain.Profile;
import br.gov.sp.fatec.mapskills.repository.MentorRepository;

public class MentorTest implements ApplicationTest{
	
	final MentorRepository persistence = new MentorRepository();
	
	@Test
	public void save() {
		final Institution fatec = new Institution("83237522000139", "Jessen Vidal", "São José");
		final Profile mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123", fatec);
		persistence.save(mentor);
		
		assertEquals(mentor.id(), persistence.findById(mentor.id()).id());
		persistence.close();
	}
	
	@Test
	public void update() {
		final Mentor mentor = persistence.findById(2);
		mentor.changeName("Marcos Silveira");
		mentor.changeInstitution(new Institution("71461173000155","Fatec Jacarei","Jacarei"));
		persistence.update(mentor);
		
		assertEquals("Marcos Silveira", persistence.findById(mentor.id()).name());
		persistence.close();
	}
	
	@Test
	public void delete() {
		final Profile mentor = persistence.findById(1);
		persistence.delete(mentor);

		Assert.assertNull(persistence.findById(1));
		persistence.close();
	}

}
