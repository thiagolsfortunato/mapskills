package br.gov.sp.fatec.mapskills.domain.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AcademicRegistry {
	
	@Column(name = "stu_ra")
	private String ra;
	
	@Column(name = "ins_code", nullable = false)
	private String institutionCode;
	
	@Column(name = "crs_code", nullable = false)
	private String courseCode;
	
	public AcademicRegistry() {}
	
	public AcademicRegistry(final String ra) throws MapSkillsException {
		validate(ra);
		this.ra = ra;
		this.institutionCode = ra.substring(0, 3);
		this.courseCode = ra.substring(3, 6);
	}
	
	public String ra() {
		return ra;
	}
	
	public String institutionCode() {
		return institutionCode;
	}
	
	public String year() {
		return ra.substring(6, 8);
	}
	
	public String semester() {
		return ra.substring(8, 9);
	}
	
	public String studentCode() {
		return ra.substring(9);
	}

	public String courseCode() {
		return courseCode;
	}
	
	//verificar o ra se nao ha nenhuma divergencia e se atente todos requisitos necessarios
	//ver lista de verify de JWT do prof
	private void validate(final String ra) throws MapSkillsException {
		try {
			Long.parseLong(ra);
			if(ra.length() < 13) throw new RAInvalidException(ra);
		} catch (final NumberFormatException e) {
			throw new RAInvalidException(ra);
		}
	}
}
