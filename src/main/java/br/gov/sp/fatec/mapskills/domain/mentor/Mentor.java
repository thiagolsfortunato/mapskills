package br.gov.sp.fatec.mapskills.domain.mentor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.Login;
import br.gov.sp.fatec.mapskills.domain.Profile;
import br.gov.sp.fatec.mapskills.domain.ProfileType;

@Entity
@Table(name = "mentor")
public class Mentor extends Profile {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6428237039193310193L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "men_id")
	private Integer id;

	@Column(name = "men_name", nullable = true)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ins_id")
	private Institution institution;
/*	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	private Login login;
*/	
	public Mentor() {
		super(ProfileType.MENTOR);
	}
	
	public Mentor(final String name, final Login login, final Institution institution) {
		super(login, ProfileType.MENTOR);
		this.name = name;
		this.institution = institution;
	}

	public Integer id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public void setName(final String newName) {
		name = newName;
	}
	
	public void changeInstitution(final Institution newInstitution) {
		this.institution.changeCompany(newInstitution.company());
		this.institution.changeCnpj(newInstitution.cnpj());
		this.institution.changeCity(newInstitution.city());
	}
	

}
