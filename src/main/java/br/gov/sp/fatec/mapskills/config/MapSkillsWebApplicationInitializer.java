/*
 * @(#)MapSkillsWebApplicationInitializer.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MapSkillsWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SpringContextConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}
	
	@Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");

        return new Filter[] {encodingFilter};
    }
	
	@Override
    protected void customizeRegistration(final ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(multipartConfigElement());
    }
	
	@Override
    public void onStartup(final ServletContext context) throws ServletException {
        super.onStartup(context);
        //context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
    }
	
	private MultipartConfigElement multipartConfigElement() {
        final String tempDir = System.getProperty("java.io.tmpdir");
        return new MultipartConfigElement(tempDir, 1024 * 1024 * 5, 1024 * 1024 * 5 * 5, 1024 * 1024);
    }

}
