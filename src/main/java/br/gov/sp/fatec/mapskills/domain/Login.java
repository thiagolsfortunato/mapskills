package br.gov.sp.fatec.mapskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private Integer id;
	
	@Column(name = "log_email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "log_password", nullable = false)
	private String password;
	
	public Login() {}
	
	public Login(final String email, final String password) {
		this.email = email;
		this.password = password;
	}

}
