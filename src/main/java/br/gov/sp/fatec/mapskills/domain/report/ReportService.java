/*
 * @(#)ReportService.java 1.0 05/03/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.report;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.output.StringBuilderWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.answerevent.AnswerEventRepository;
import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
/**
 * 
 * @author Marcelo
 *
 */
@Service
public class ReportService {
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private AnswerEventRepository answerEventRepository;
	
	@Autowired
	private ReportRepository reportRepository;
	
	/**
	 * 
	 * @param institutionCode
	 * @return
	 * @throws IOException
	 */
	public byte[] getCsvReport(final String institutionCode) throws IOException {
//		final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("report.csv"), "UTF-8"));
		final BufferedWriter bw = new BufferedWriter(new StringBuilderWriter());
		bw.write(generateHeader());
		bw.newLine();
		final List<Object[]> resultSet = reportRepository.findReportByInstitutionCode(institutionCode);
		for(final Object[] tuple : resultSet) {
			final StringBuffer csvLine = generateDataInfo(tuple);
			final long studentId = Long.parseLong(tuple[0].toString());
			final List<Object[]> radarResult = answerEventRepository.findResultViewByStudentId(studentId);
			for(final Object[] resultGame : radarResult) {
				generateResultGame(resultGame, csvLine);
			}
			bw.write(csvLine.toString());
			bw.newLine();
		}
		bw.flush();
        bw.close();
		return bw.toString().getBytes();
	}
	/**
	 * metodo responsavel por escrever todo o cabecalho do relatorio.
	 * gerando as competencias dinamicamente.
	 * 
	 * @return
	 */
	private String generateHeader() {
		final StringBuilder defaultHeader = new StringBuilder("RA;ALUNO;CURSO;INSTITUIÇÃO;ANO/SEMESTRE;");
		for(final Skill skill : skillService.findAll()) {
			defaultHeader.append(String.format("%s;", skill.getType().toUpperCase()));
		}
		return defaultHeader.toString();
	}
	/**
	 * metodo responsavel por escrever todas informacoes
	 * basicas do aluno que aparecera no relatorio.
	 * 
	 * @param tuple
	 * @return
	 */
	private StringBuffer generateDataInfo(final Object[] tuple) {
		final StringBuffer dataInfo = new StringBuffer();
		for(int i = 1; i < tuple.length; i++) {
			dataInfo.append(tuple[i].toString().concat(";"));
		}
		return dataInfo;
	}
	/**
	 * metodo responsavel por escrever todos os resultados das competencias
	 * de um aluno gerada pela aplicacao.
	 * 
	 * @param resultGame
	 * @param dataInfo
	 */
	private void generateResultGame(final Object[] resultGame, final StringBuffer dataInfo) {
		dataInfo.append(resultGame[3] == null ? "" : resultGame[3].toString().concat(";"));
	}

}
