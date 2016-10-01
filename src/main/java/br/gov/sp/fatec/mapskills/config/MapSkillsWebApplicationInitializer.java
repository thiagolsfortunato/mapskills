package br.gov.sp.fatec.mapskills.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MapSkillsWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
		implements WebApplicationInitializer {

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
    public void onStartup(final ServletContext context) throws ServletException {
        super.onStartup(context);
        //context.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class).addMappingForUrlPatterns(null, false, "/*");
    }

}
