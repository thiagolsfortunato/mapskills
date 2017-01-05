package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SaveImageService {
	
	private Base64Parser parser = BeanRetriever.getBean("base64Parser", Base64Parser.class);
	private final InputStream inputStream;
	
	public SaveImageService(final String base64) {
		this.inputStream = parser.toInputStream(base64);
	}
	
	public String save(final String filename, final int filesize) {
		
		OutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(new File("../../images/" + filename));
			int read = 0;
			final byte[] bytes = new byte[filesize];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
