/*
 * @(#)AbstractApplicationTest.java 1.0 13/01/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.test.config;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.gov.sp.fatec.mapskills.authentication.jwt.JwtAuthenticationManager;
import br.gov.sp.fatec.mapskills.config.WebConfig;
/**
 * A classe <code>AbstractApplicationTest</code> representa as configurações
 * globais de teste, para todos outros testes.
 * @author Marcelo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringContextTestConfiguration.class, WebConfig.class})
public abstract class AbstractApplicationTest {
	
	protected static final String AUTHORIZATION = "Authorization";
	
	@Mock
	protected JwtAuthenticationManager jwtAuthenticationManager;
	
	@Autowired
	protected AbstractPreAuthenticatedProcessingFilter filter;
	
	@Autowired
    protected WebApplicationContext wac;
	
	@Autowired
    private Filter springSecurityFilterChain;
	
	@Autowired
	protected PasswordEncoder encoder;
	
	protected MockMvc mockMvc;
	/**
	 * configuração inicial para mockar os teste de integração
	 */
	@Before
    public void setup() {
		mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .addFilters(springSecurityFilterChain)
                .build();
		
		MockitoAnnotations.initMocks(this);
		filter.setAuthenticationManager(jwtAuthenticationManager);
    }

}
