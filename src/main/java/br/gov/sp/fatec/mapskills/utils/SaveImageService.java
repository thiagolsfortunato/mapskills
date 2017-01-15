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

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>SaveImageService</code> é responsavel por salvar as
 * images feitas por upload pela aplicação.
 * @author Marcelo
 *
 */
@Component
public class SaveImageService {

	private ServletContext context;
	private String PATH;
	private Base64Parser parser = BeanRetriever.getBean("base64Parser", Base64Parser.class);
	
	/**
	 * Método que salva a imagem no diretorio do servidor definido como padrão
	 * @param base64
	 * @param filename
	 * @return
	 * @throws MapSkillsException 
	 */
	public String save(final String base64, final String filename) throws MapSkillsException {
		this.PATH = context.getRealPath("/images");
		try (final OutputStream stream = new FileOutputStream(PATH.concat("/").concat(filename))) {
		    stream.write(parser.toByteArray(base64));
		    stream.close();
		} catch (final IOException e) {
			e.printStackTrace();
			throw new SaveImageException(filename);
		}
		return filename;
	}
	
	@Autowired
	public void setServletContext(final ServletContext servletContext) {
		this.context = servletContext;
	}


}
