/*
 * @(#)ReportService.java 1.0 05/03/2017
 *
 * Copyright (c) 2017, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
/**
 * 
 * A classe {@link ReportService} contem as regras de negocio
 * para geracao de relatorios da aplicacao sendo as competencias
 * geradas dinamicamente de acordo com a quantidade cadastrada.
 *
 * @author Marcelo
 * @version 1.0 05/03/2017
 */
@Service
public class ReportService {
	
	private static final String SEMICOLON = ";";
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ReportRepository reportRepository;
	
	/**
	 * 
	 * @param institutionCode
	 * @return
	 * @throws IOException
	 */
	public byte[] getCsvReport(final ReportFilter filter) throws IOException {
		final StringBuilder stringBuilder = new StringBuilder();
		generateHeader(stringBuilder);
		final Specification<ReportDefaultData> specification = ReportSpecification.byFilter(filter);
		final List<ReportDefaultData> resultSet = reportRepository.findAll(specification);
		for(final ReportDefaultData data : resultSet) {
			final StringBuilder csvLine = generateDataInfo(data);
			final List<Object> skillsResult = reportRepository.findAllSkillsByStudentId(data.getStudentId());
			for(final Object resultGame : skillsResult) {
				generateResultGame(resultGame, csvLine);
			}
			stringBuilder.append(csvLine.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString().getBytes();
	}
	
	public List<ReportDefaultData> getReportDatas(final Specification<ReportDefaultData> specification) {
		return reportRepository.findAll(specification);
	}
	
	public List<Object> getScoresByStudentId(final long studentId) {
		return reportRepository.findAllSkillsByStudentId(studentId);
	}
	
	/**
	 * metodo responsavel por escrever todo o cabecalho do relatorio.
	 * gerando as competencias dinamicamente.
	 * 
	 * @return
	 */
	private void generateHeader(final StringBuilder stringBuilder) {
		final StringBuilder defaultHeader = new StringBuilder("RA;ALUNO;CURSO;CODIGO INSTITUIÇÃO;INSTITUIÇÃO;ANO/SEMESTRE;");
		for(final Skill skill : skillService.findAll()) {
			defaultHeader.append(String.format("%s;", skill.getType().toUpperCase()));
		}
		stringBuilder.append(defaultHeader);
		stringBuilder.append("\n");
	}
	/**
	 * metodo responsavel por escrever todas informacoes
	 * basicas do aluno que aparecera no relatorio.
	 * 
	 * @param tuple
	 * @return
	 */
	private StringBuilder generateDataInfo(final ReportDefaultData data) {
		final StringBuilder dataInfo = new StringBuilder();
		dataInfo.append(data.getStudentRA()).append(SEMICOLON)
			.append(data.getStudentName()).append(SEMICOLON)
			.append(data.getCourseName()).append(SEMICOLON)
			.append(data.getInstitutionCompany()).append(SEMICOLON)
			.append(data.getInstitutionCode()).append(SEMICOLON)
			.append(data.getYaerSemester()).append(SEMICOLON);
		return dataInfo;
	}
	/**
	 * metodo responsavel por escrever todos os resultados das competencias
	 * de um aluno gerada pela aplicacao.
	 * 
	 * @param resultGame
	 * @param dataInfo
	 */
	private void generateResultGame(final Object skillResult, final StringBuilder dataInfo) {
		dataInfo.append(skillResult == null ? "N/A" : skillResult.toString()).append(SEMICOLON);
	}

}
