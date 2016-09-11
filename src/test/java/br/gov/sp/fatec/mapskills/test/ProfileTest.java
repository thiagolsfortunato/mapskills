package br.gov.sp.fatec.mapskills.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import br.gov.sp.fatec.mapskills.domain.Institution;
import br.gov.sp.fatec.mapskills.domain.Mentor;
import br.gov.sp.fatec.mapskills.domain.Profile;
import br.gov.sp.fatec.mapskills.repository.MentorRepository;
import br.gov.sp.fatec.mapskills.repository.Repository;

public class ProfileTest {
	
	Repository persistence = new MentorRepository();
	
	@Test
	public void save() {
		Institution fatec = new Institution("83237522000139", "Jessen Vidal", "São José");
		Profile mentor = new Mentor("Mentor Responsavel Teste", "marquinhos@fatec", "Mudar@123", fatec);
		persistence.save(mentor);
		
		assertEquals(mentor.id(), persistence.findById(mentor.id()).id());
		persistence.close();
	}
	
	@Test
	public void update() {
		Profile mentor = persistence.findById(1);
		mentor.changeName("Marcos Silveira");
		persistence.update(mentor);
		
		assertEquals("Marcos Silveira", persistence.findById(mentor.id()).name());
		persistence.close();
	}
	
	@Test
	public void delete() {
		Profile mentor = persistence.findById(1);
		persistence.delete(mentor);

		Assert.assertNull(persistence.findById(1));
		persistence.close();
	}

}
