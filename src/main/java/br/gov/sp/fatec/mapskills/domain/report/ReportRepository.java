package br.gov.sp.fatec.mapskills.domain.report;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEvent;

public interface ReportRepository extends Repository<AnswerEvent, Long> {
	
	@Query(value="SELECT * FROM CSV_REPORT_VIEW WHERE institution.ins_code = ?1", nativeQuery = true)
	public List<Object[]> findReportByInstitutionCode(final String institutionCode);

}
