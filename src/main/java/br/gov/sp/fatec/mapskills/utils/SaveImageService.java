/*
 * @(#)SaveImageService.java 1.0 06/01/2017
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>SaveImageService</code> eh responsavel por salvar as
 * images feitas por upload pela aplicacao.
 * @author Marcelo
 *
 */
@Component
public class SaveImageService {
	
	private static final Logger LOGGER = Logger.getLogger( SaveImageService.class.getName() );
	
	private ServletContext context;
	private Base64Parser parser = BeanRetriever.getBean("base64Parser", Base64Parser.class);
	
	/**
	 * Metodo que salva a imagem no diretorio do servidor definido como padrao
	 * @param base64
	 * @param filename
	 * @return
	 * @throws MapSkillsException 
	 */
	public String save(final String base64, final String filename) throws MapSkillsException {
		if(base64 == null) {
			return null;
		}
		final String path = context.getRealPath("/images");
		try (final OutputStream stream = new FileOutputStream(path.concat("/").concat(filename))) {
		    stream.write(parser.toByteArray(base64));
		    stream.close();
		    return filename;
		} catch (final IOException e) {
			LOGGER.info(e.getMessage());
			throw new SaveImageException(filename, e);
		}
	}
	
	@Autowired
	public void setServletContext(final ServletContext servletContext) {
		this.context = servletContext;
	}


}
