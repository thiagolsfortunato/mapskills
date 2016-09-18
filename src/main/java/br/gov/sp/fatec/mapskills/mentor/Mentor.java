package br.gov.sp.fatec.mapskills.mentor;

import java.io.Serializable;

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

import br.gov.sp.fatec.mapskills.domain.Profile;

@Entity
@Table(name="mentor")
public class Mentor implements Profile, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8734152933324471676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "men_id")
	private Integer id;
	
	@Column(name = "men_name", nullable = true)
	private String name;
	
	@Column(name = "men_email", nullable = true, unique = true)
	private String email;
	
	@Column(name = "men_password", nullable = true)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ins_id")
	private Institution institution;
	
	public Mentor() {}
	
	public Mentor(final String name, final String email, final String password, final Institution institution) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.institution = institution;
	}

	public Integer id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public void setName(final String newName) {
		this.name = newName;
	}
	
	public void changeInstitution(final Institution newInstitution) {
		this.institution.changeCompany(newInstitution.company());
		this.institution.changeCnpj(newInstitution.cnpj());
		this.institution.changeCity(newInstitution.city());
	}

}
