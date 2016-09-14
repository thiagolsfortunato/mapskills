package br.gov.sp.fatec.mapskills.question;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
		
	@Query("SELECT q FROM Question q ORDER BY q.index")
	public List<Question> questionList();
	
	public Question findById(final Integer id);
	
}
