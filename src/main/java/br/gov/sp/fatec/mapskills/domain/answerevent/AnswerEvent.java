/* @(#)AnswerEvent.java 1.0 04/01/2017
 *
 * Copyright (c) 2017, Fatec-Jessen Vidal. All rights reserved.
 * Fatec-Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
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

import lombok.Builder;
import lombok.Getter;
/**
 * 
 * A classe {@link AnswerEvent} representa todas as informacoes de
 * escolha de uma alternativa de uma questao respondida durante o jogo.
 *
 * @author Marcelo
 * @version 1.0 04/01/2017
 */
@Getter
@Entity
@Table(name = "STUDENT_QUESTION_EVENT")
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
	
	public AnswerEvent() {
		// CONSTRUCTOR DEFAULT
	}
	
	@Builder
	public AnswerEvent(final int sceneIndex, final long sceneId, final long studentId,
			final long skillId, final int skillValue) {
		this.sceneIndex = sceneIndex;
		this.sceneId = sceneId;
		this.studentId = studentId;
		this.skillId = skillId;
		this.skillValue = skillValue;
		this.date = Calendar.getInstance();
	}

	public String getDate() {
		return calendarDateFormatterPtBr(date);
	}
	
	/**
	 * Método que formata data no idioma portugues do Brasil
	 * @param date
	 * @return
	 */
	private String calendarDateFormatterPtBr(final Calendar date) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return dateFormat.format(date);
	}

}
