package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

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
