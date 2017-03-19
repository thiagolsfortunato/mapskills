package br.gov.sp.fatec.mapskills.domain.answerevent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AnswerEventRepository extends CrudRepository<AnswerEvent, Long> {
	
/*	@Query(value = "SELECT new br.gov.sp.fatec.mapskills.restapi.wrapper.Result(s.type, s.description, SUM(a.skillValue))"
			+ " FROM AnswerEvent a INNER JOIN Skill s"
			+ " ON a.skillId = s.id WHERE a.studentId = ?1 GROUP BY s.type, s.description ORDER BY s.type ASC")
	public List<Result> findResultSkillByStudentId(final long studentId); */
	/**
	 * query que retorna resultado de um view criada para renderização
	 * do grafico de radar 
	 * @param studentId
	 * @return
	 */
	@Query(value="SELECT * FROM RADAR_RESULT_VIEW RADAR WHERE RADAR.USER_ID = ?1", nativeQuery = true)
	public List<Object[]> findResultViewByStudentId(final long studentId);
	  
}
