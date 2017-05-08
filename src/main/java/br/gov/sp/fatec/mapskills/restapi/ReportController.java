/*
 * @(#)ReportController.java 1.0 11/03/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.mapskills.domain.skill.Skill;
import br.gov.sp.fatec.mapskills.domain.skill.SkillService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.ReportDefaultData;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.ReportFilter;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.ReportService;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.ReportSpecification;
import br.gov.sp.fatec.mapskills.restapi.wrapper.report.ReportViewWrapper;

@RestController
public class ReportController {
	
	private static final Logger LOGGER = Logger.getLogger(ReportController.class.getName());
		
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private SkillService skillService;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/report/download", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<byte[]> getReportDownload(@RequestBody final ReportFilter filter, final HttpServletResponse response) {
		try {
			final byte[] report = reportService.getCsvReport(filter);
			final HttpHeaders httpHeaders = new HttpHeaders();
		    httpHeaders.add("Content-Disposition", "attachment; filename=report.csv" );
		    response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		    response.setCharacterEncoding("UTF-8");
			return new HttpEntity<>(report, httpHeaders);
		} catch (final IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/report/view", method = RequestMethod.POST)
	public ResponseEntity<ReportViewWrapper> getReportView(@RequestBody final ReportFilter filter) {
		final List<Skill> skills = new ArrayList<>();
		final List<ReportDefaultData> datas = new ArrayList<>();
		datas.addAll(reportService.getReportDatas(ReportSpecification.byFilter(filter)));
		for(final ReportDefaultData data : datas) {
			data.setScores(reportService.getScoresByStudentId(data.getStudentId()));
		}
		skills.addAll(skillService.findAll());
		
		final ReportViewWrapper reportView = new ReportViewWrapper(skills, datas);
		return new ResponseEntity<>(reportView, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/image/{image_name}", method = RequestMethod.GET)
	@ResponseBody
	public void getImageAsResource(@PathVariable("image_name") final String imageName,
			final HttpServletResponse response) throws IOException {
		
		final InputStream in = servletContext.getResourceAsStream("/images/"+imageName+".jpg");
	    response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	    IOUtils.copy(in, response.getOutputStream());
	}

}
