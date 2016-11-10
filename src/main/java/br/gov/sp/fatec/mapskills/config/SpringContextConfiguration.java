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
//@Import({DataBaseConfig.class})
@Import({DataBaseHsqldbConfig.class, MapSkillsBeans.class})
@ComponentScan(basePackages = {"br.gov.sp.fatec.mapskills.domain.user",
		"br.gov.sp.fatec.mapskills.domain.institution",
		"br.gov.sp.fatec.mapskills.domain.skill",
		"br.gov.sp.fatec.mapskills.domain.theme",
		"br.gov.sp.fatec.mapskills.utils"})
@EnableJpaRepositories(basePackages = {"br.gov.sp.fatec.mapskills.domain.user",
		"br.gov.sp.fatec.mapskills.domain.institution",
		"br.gov.sp.fatec.mapskills.domain.skill",
		"br.gov.sp.fatec.mapskills.domain.theme",})
public class SpringContextConfiguration {
}
