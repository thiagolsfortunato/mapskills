package br.gov.sp.fatec.mapskills.domain.answerevent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.mapskills.restapi.wrapper.Result;

public interface AnswerEventRepository extends CrudRepository<AnswerEvent, Long> {
	
	@Query("SELECT s.type, SUM(a.skillValue) AS total FROM AnswerEvent a INNER JOIN Skill s"
			+ " ON a.skillId = s.id WHERE a.studentId = ?1 GROUP BY s.type ORDER BY s.type DESC")
	public List<Object[]> findResultByStudentId(final long studentId);
	
	@Query(value = "SELECT new br.gov.sp.fatec.mapskills.restapi.wrapper.Result(s.type, s.description, SUM(a.skillValue))"
			+ " FROM AnswerEvent a INNER JOIN Skill s"
			+ " ON a.skillId = s.id WHERE a.studentId = ?1 GROUP BY s.type ORDER BY s.type DESC")
	public List<Result> findResultSkillByStudentId(final long studentId);
	
	@Query(value="SELECT * FROM RADAR_RESULT R WHERE R.USE_ID = ?1", nativeQuery = true)
	public List<Object[]> findResultViewByStudentId(final long studentId);
	  
}
