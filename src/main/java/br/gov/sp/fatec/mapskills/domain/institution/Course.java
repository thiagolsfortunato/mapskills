package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "crs_id")
	private long id;
	
	@Column(name = "crs_code")
	private String code;
	
	@Column(name = "crs_name")
	private String name;
	
	@Column(name = "crs_period")
	@Enumerated(value = EnumType.STRING)
	private CoursePeriod period;
	
	@Column(name = "ins_code", length = 10)
	private String institutionCode;
	
	public Course() {}
	
	public Course(final String code, final String name, final CoursePeriod period, final String institutionCode) {
		this.code = code;
		this.name = name;
		this.period = period;
		this.institutionCode = institutionCode;
	}
	
	public long getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPeriod() {
		return period.name();
	}
	
	public String getInstitutionCode() {
		return institutionCode;
	}
	
	public void setId(final long id) {
		this.id = id;
	}

}
