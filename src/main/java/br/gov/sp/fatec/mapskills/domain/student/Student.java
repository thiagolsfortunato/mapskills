package br.gov.sp.fatec.mapskills.domain.student;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.Login;
import br.gov.sp.fatec.mapskills.domain.Profile;
import br.gov.sp.fatec.mapskills.domain.ProfileType;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;

@Entity
@Table(name = "student")
public class Student extends Profile {
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
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "ins_id", nullable = false)
	private Integer institutionId;
	
	private Map<Skill, Integer> skillMap;
/*	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	private Login login;
*/	
	public Student() {
		super(ProfileType.STUDENT);
		skillMap = new HashMap<Skill, Integer>();
	}
	
	public Student(final String name, final Integer ra, final String phone, final Integer institutionId, final Login login) {
		super(login, ProfileType.STUDENT);
		this.name = name;
		this.ra = ra;
		this.phone = phone;
		this.institutionId = institutionId;
		skillMap = new HashMap<Skill, Integer>();
	}
	
	public Integer id() {
		return id;
	}
	
	public String name() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public Map<Skill, Integer> getSkillMap() {
		return skillMap;
	}
	

}
