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
