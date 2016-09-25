package br.gov.sp.fatec.mapskills.domain.administrator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.Login;
import br.gov.sp.fatec.mapskills.domain.Profile;
import br.gov.sp.fatec.mapskills.domain.ProfileType;

@Entity
@Table(name = "administrator")
public class Administrator extends Profile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704854251791882324L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "adm_id")
	private Integer id;
	
	@Column(name = "adm_name", nullable = false)
	private String name;
		
	public Administrator(final String name, final Login login) {
		super(login, ProfileType.ADMINISTRATOR);
		this.name = name;
	}

}
