package br.gov.sp.fatec.mapskills.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.sp.fatec.mapskills.domain.ProfileType;
import br.gov.sp.fatec.mapskills.domain.User;

@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "use_id")
public class Student extends User {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "stu_ra", nullable = false)
	private Integer ra;
	
	@Column(name = "stu_phone", nullable = false)
	private String phone;
	
	@Column(name = "ins_id", nullable = false)
	private Integer institutionId;
	
	//private Map<Skill, Integer> skillMap = new HashMap<Skill, Integer>();
/*	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "log_id")
	private Login login;
*/	
	public Student() { }
	
	public Student(final String name, final Integer ra, final String phone, final Integer institutionId, final String email, final String password) {
		super(name, email, password, ProfileType.STUDENT);
		this.ra = ra;
		this.phone = phone;
		this.institutionId = institutionId;
		//skillMap = new HashMap<Skill, Integer>();
	}

	

}
