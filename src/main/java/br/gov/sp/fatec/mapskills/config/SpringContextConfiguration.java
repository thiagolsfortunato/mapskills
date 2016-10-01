package br.gov.sp.fatec.mapskills.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
//@ComponentScan(basePackages = {"br.gov.sp.fatec.mapskills.restapi.serializer",""})
//@PropertySource({""})
//@Import({DomainEventsBeans.class})
@ImportResource("applicationContext.xml")
public class SpringContextConfiguration {

}
