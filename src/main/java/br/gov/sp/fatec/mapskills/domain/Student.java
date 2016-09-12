package br.gov.sp.fatec.mapskills.domain;

public class Student implements Profile {
	
	private Integer id;
	private String name;
	private Integer ra;
	private String email;
	private String password;
	private String phone;
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

	public void changeName(String newName) {
		this.name = newName;
	}
	

}
