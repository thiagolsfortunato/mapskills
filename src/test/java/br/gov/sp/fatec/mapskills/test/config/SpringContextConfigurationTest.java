/*
 * @(#)SpringContextConfigurationTest.java 1.0 13/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.config;

import org.springframework.context.annotation.Import;

import br.gov.sp.fatec.mapskills.config.AbstractSpringContextConfiguration;
import br.gov.sp.fatec.mapskills.config.DataBaseHsqldbConfig;
/**
 * A classe <code>SpringContextConfigurationTest</code> representa as configurações
 * necessárias para o realização dos testes da aplicação.
 * 
 * @author Marcelo
 *
 */
@Import({DataBaseHsqldbConfig.class})
public class SpringContextConfigurationTest extends AbstractSpringContextConfiguration {
}
