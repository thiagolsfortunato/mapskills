package br.gov.sp.fatec.mapskills.domain.scene;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SceneRepository extends CrudRepository<Scene, Long> {
	
	/**
	 * Método recupera o próximo index valido para uma questão de um tema
	 * @param themeId
	 * @return
	 */
	@Query("SELECT (COUNT(*)) FROM Scene s INNER JOIN GameTheme t ON s.gameThemeId = t.id WHERE t.id = ?1")
	public int findNextIndex(final long themeId);
	
	/**
	 * BUSCAR TODAS CENAS HABILITADAS, ORDENADAS E AINDA NÃO RESPONDIDAS POR UM
	 * DETERMINADO ALUNO DE UMA INSTITUIÇÃO QUE TEM UM TEMA ATIVO
	 * @param id
	 * @return
	 */
	/*@Query("SELECT s FROM Scene s INNER JOIN GameTheme t ON s.gameThemeId = t.id "
			+ "INNER JOIN institution i ON t.id = i.gameThemeId"
			+ "INNER JOIN student st ON st.ra.institutionCode = i.code WHERE st.id = ?1"
			+ "AND NOT EXISTS (SELECT s FROM Scene s INNER JOIN AnswerEvent ae ON s.id = ae.sceneId "
			+ "INNER JOIN Student st ON ae.studentId = st.id WHERE st.id = ?1) ORDER BY s.index")
	public List<Scene> findAllByEnableAndNotAnaswerByStudent(final long studentId);
	*/
	public List<Scene> findAllByGameThemeIdAndEnabled(final long gameThemeId, final boolean enabled);

	
}
