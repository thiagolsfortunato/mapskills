package br.gov.sp.fatec.mapskills.domain.user;

public class AcademicRegistry {
	
	private final String institutionCode;
	private final String courseCode;
	private final String year;
	private final String semester;
	private final String studentCode;
	
	public AcademicRegistry(final String ra) throws MapSkillsException {
		validate(ra);
		institutionCode = ra.substring(0, 3);
		courseCode = ra.substring(3, 6);
		year = ra.substring(6, 10);
		semester = ra.substring(10, 11);
		studentCode = ra.substring(11);
	}
	
	public String ra() {
		return institutionCode.concat(courseCode).concat(year).concat(semester).concat(studentCode);
	}
	
	public String year() {
		return year;
	}
	
	public String courseCode() {
		return courseCode;
	}
	
	//verificar o ra se nao ha nenhuma divergencia e se atente todos requisitos necessarios
	//ver lista de verify de JWT do prof
	private void validate(final String ra) throws MapSkillsException {
		try {
			Long.parseLong(ra);
			if(ra.length() < 14) throw new RAInvalidException(ra);
		} catch (final NumberFormatException e) {
			throw new RAInvalidException(ra);
		}
	}
}
