package br.gov.sp.fatec.mapskills.domain.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_question_event")
public class AnswerEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sqe_id")
	private long id;
	
	@Column(name = "use_id", nullable = false)
	private long studentId;
	
	@Column(name = "que_id", nullable = false)
	private long questionId;
	
	@Column(name = "alt_id", nullable = false)
	private long alternativeId;
	
	@Column(name = "ski_id", nullable = false)
	private long skillId;
	
	@Column(name = "sqe_skill_value", nullable = false)
	private int skillValue;
	
	@Column(name = "sqe_date", nullable = false)
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date;
	
	public AnswerEvent() {}
	
	public AnswerEvent(final long studentId, final long questionId,
			final long alternativeId, final long skillId, final int skillValue) {
		
		this.studentId = studentId;
		this.questionId = questionId;
		this.alternativeId = alternativeId;
		this.skillId = skillId;
		this.skillValue = skillValue;
		this.date = LocalDateTime.now();
	}
	
	public long getStudentId() {
		return studentId;
	}
	
	public long getQuestionId() {
		return questionId;
	}
	
	public long getAlternativeId() {
		return alternativeId;
	}
	
	public long getSkillId() {
		return skillId;
	}
	
	public int getSkillValue() {
		return skillValue;
	}
	
	public String getDate() {
		return dateFormatterPtBr(date);
	}
	
	/**
	 * Método que formata data no idioma portugues do Brasil
	 * @param date
	 * @return
	 */
	private String dateFormatterPtBr(final LocalDateTime date) {
		final DateTimeFormatter formatter = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(new Locale("pt", "br"));
		return date.format(formatter);
	}

}
