package br.gov.sp.fatec.mapskills.domain.answerevent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerEventRepository extends CrudRepository<AnswerEvent, Long> {
	
	@Query("SELECT s.type, SUM(a.skillValue) AS total FROM AnswerEvent a INNER JOIN Skill s"
			+ " ON a.skillId = s.id WHERE a.studentId = ?1 GROUP BY s.type ORDER BY s.type DESC")
	public List<Object[]> findResultByStudentId(final long studentId);
}
