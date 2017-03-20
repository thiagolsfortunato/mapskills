/*
 * @(#)ReportSpecification.java 1.0 18/03/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.restapi.wrapper.report;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
/**
 * A classe <code>ReportSpecification</code> é responsavel
 * por "montar" as condicionais da clausula WHERE da query
 * de acordo com os atributos da classe <code>ReportFilter</code>
 * 
 * @author Marcelo
 *
 */
public final class ReportSpecification {
	
	private ReportSpecification() {
	}
	
	public static Specification<ReportDefaultData> byFilter(final ReportFilter filter) {
	    return new Specification<ReportDefaultData>() {
	      @Override
	      public Predicate toPredicate(final Root<ReportDefaultData> root, final CriteriaQuery<?> query,
	    		  final CriteriaBuilder builder) {
	    	  
	        final List<Predicate> predicates = new LinkedList<>();
	        //TODO melhoria futura, implementar padrão de projeto chain of responsability
	        if (!StringUtils.isEmpty(filter.getLevelInstitution())) {
	        	predicates.add(builder.equal(root.<String>get("institutionLevel"), filter.getLevelInstitution().name()));
	        }
	        if (!StringUtils.isEmpty(filter.getInstitutionCode())) {
	        	predicates.add(builder.equal(root.<String>get("institutionCode"), filter.getInstitutionCode()));
	        }
	        if (!StringUtils.isEmpty(filter.getCourseCode())) {
	        	predicates.add(builder.equal(root.<String>get("courseCode"), filter.getCourseCode()));
	        }
	        if (!StringUtils.isEmpty(filter.getStartDate())) {
	        	predicates.add(builder.greaterThanOrEqualTo(root.<String>get("yaerSemester"), filter.getStartDate()));
	        }
	        if (!StringUtils.isEmpty(filter.getEndDate())) {
	        	predicates.add(builder.lessThanOrEqualTo(root.<String>get("yaerSemester"), filter.getEndDate()));
		    }
	        return builder.and(predicates.toArray(new Predicate[]{}));
	      }
	    };
	  }

}
