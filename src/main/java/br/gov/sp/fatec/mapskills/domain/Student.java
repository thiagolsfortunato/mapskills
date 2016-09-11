package br.gov.sp.fatec.mapskills.domain;

public class Student implements Profile {
	
	private Integer id;
	private String name;
	private Integer ra;
	private String email;
	private String phone;
	private Integer institutionId;
	
	public Student() {}

	public Integer id() {
		return id;
	}
	

}
