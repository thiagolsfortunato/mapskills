/*
 * @(#)SpringContextConfiguration.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
/**
 * A classe <code>SpringContextConfiguration</code> representa as configurações
 * necessárias para o uso da aplicação em produção.
 * 
 * @author Marcelo
 *
 */
@PropertySource("classpath:application.properties")
@Import({DataBaseHsqldbConfig.class, SecurityConfig.class, SetupApplicationToInitializeGame.class})
public class SpringContextConfiguration extends AbstractSpringContextConfiguration {	
}
