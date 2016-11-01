/*
 * @(#)SpringContextConfiguration.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
//@PropertySource({""})
//@Import({DomainEventsBeans.class})
//@ImportResource("applicationContext.xml")
@ComponentScan(basePackages = {"br.gov.sp.fatec.mapskills"})
@EnableJpaRepositories(basePackages = {"br.gov.sp.fatec.mapskills.domain.student"})
public class SpringContextConfiguration {
}
