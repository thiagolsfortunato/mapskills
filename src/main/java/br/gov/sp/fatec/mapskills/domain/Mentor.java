package br.gov.sp.fatec.mapskills.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mentor")
public class Mentor implements Profile {
	@Id
	@GeneratedValue
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
	
	public void changeName(final String newName) {
		this.name = newName;
	}

}
