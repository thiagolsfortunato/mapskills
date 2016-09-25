package br.gov.sp.fatec.mapskills.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4293076747119096997L;
		
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	protected Login login;
	
	protected Profile(final ProfileType profile) {
		login = new Login();
		login.profile(profile);
	}
	
	protected Profile(final Login login, ProfileType profile) {
		this.login = login;
		login.profile(profile);
	}


}
