/*
 * @(#)SpringContextConfiguration.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved.
 * Fatec Jessen Vidal proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * A classe {@link SpringContextConfiguration} representa as
 * configuracoes necessarias para o uso da aplicacao em producao.
 *
 * @author Marcelo
 * @version 1.0 01/11/2016
 */
@Configuration
@Import({DataBaseConfig.class})
public class SpringContextConfiguration extends AbstractSpringContextConfiguration {
	
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
}
