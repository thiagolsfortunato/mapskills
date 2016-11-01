/*
 * @(#)MultipartParser.java 1.0 01/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
/**
 * A classe <code>MultipartParser</code> tem a resposabilidade de converter objetos MultipartFile
 * em objeto File.
 * 
 * @author HyperClass04
 *
 */
public class MultipartParser {
	
	public File toFile(final MultipartFile file) throws IOException {    
	    final File converter = new File(file.getOriginalFilename());
	    converter.createNewFile(); 
	    final FileOutputStream fos = new FileOutputStream(converter); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return converter;
	}

}
