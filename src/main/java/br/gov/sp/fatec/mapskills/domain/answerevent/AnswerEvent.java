package br.gov.sp.fatec.mapskills.domain.answerevent;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student_question_event")
public class AnswerEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sqe_id")
	private long id;
	
	@Column(name = "sqe_skill_value")
	private int skillValue;
	
	@Column(name = "ski_id")
	private long skillId;

	@Column(name = "use_id", nullable = false)
	private long studentId;
	
	@Column(name = "scn_id", nullable = false)
	private long sceneId;
	
	@Column(name = "scn_index", nullable = false)
	private int sceneIndex;
			
	@Column(name = "sqe_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;
	
	public AnswerEvent() {}
	
	public AnswerEvent(final int sceneIndex, final long sceneId, final long studentId, final long skillId, final int skillValue) {
		this.sceneIndex = sceneIndex;
		this.sceneId = sceneId;
		this.studentId = studentId;
		this.skillId = skillId;
		this.skillValue = skillValue;
		this.date = Calendar.getInstance();
	}
	
	public long getSceneId() {
		return sceneId;
	}
	
	public int getSceneIndex() {
		return sceneIndex;
	}
	
	public long getStudentId() {
		return studentId;
	}
	
	public long getSkillId() {
		return skillId;
	}
	
	public int getSkillValue() {
		return skillValue;
	}
	
	public String getDate() {
		return calendarDateFormatterPtBr(date);
	}
	
	/**
	 * Método que formata data no idioma portugues do Brasil
	 * @param date
	 * @return
	 */
	/* Método que formata com a classe LocalDateTime
	 * private String dateFormatterPtBr(final LocalDateTime date) {
		final DateTimeFormatter formatter = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT)
				.withLocale(new Locale("pt", "br"));
		return date.format(formatter);
	}*/
	private String calendarDateFormatterPtBr(final Calendar date) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return dateFormat.format(date);
	}

}
