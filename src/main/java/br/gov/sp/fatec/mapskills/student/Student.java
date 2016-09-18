package br.gov.sp.fatec.mapskills.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.Profile;

@Entity
@Table(name = "student")
public class Student implements Profile, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6161259826708802596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stu_id")
	private Integer id;
	
	@Column(name = "stu_name", nullable = false)
	private String name;
	
	@Column(name = "stu_ra", nullable = false)
	private Integer ra;
	
	@Column(name = "stu_email", nullable = false)
	private String email;
	
	@Column(name = "stu_password", nullable = false)
	private String password;
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "ins_id", nullable = false)
	private Integer institutionId;
	
	public Student() {}
	
	public Student(final String name, final Integer ra, final String email, final String password, final String phone) {
		this.name = name;
		this.ra = ra;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public Integer id() {
		return id;
	}

	public String name() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	

}
