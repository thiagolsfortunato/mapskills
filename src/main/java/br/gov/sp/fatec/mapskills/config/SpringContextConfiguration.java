/*
 * @(#)SpringContextConfiguration.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@PropertySource("classpath:application.properties")
//@Import({DomainEventsBeans.class})
//@ImportResource("applicationContext.xml")
@Import({DataBaseConfig.class})
@ComponentScan(basePackages = {"br.gov.sp.fatec.mapskills.domain.user"})
@EnableJpaRepositories(basePackages = {"br.gov.sp.fatec.mapskills.domain.user"})
public class SpringContextConfiguration {
}
