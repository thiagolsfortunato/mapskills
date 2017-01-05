package br.gov.sp.fatec.mapskills.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

@Component
public class SaveImageService {
	
	private Base64Parser parser = BeanRetriever.getBean("base64Parser", Base64Parser.class);
	
	public SaveImageService() {}
	
	public String save(final String base64, final String filename) {
		
		try (final OutputStream stream = new FileOutputStream("src/main/resources/images/"+filename)) {
		    stream.write(parser.toByteArray(base64));
		    stream.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return filename;
	}

}
