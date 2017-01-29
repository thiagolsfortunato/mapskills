/*
 * @(#)PoiParser.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
/**
 * A classe <code>UserXLSXParser</code> tem objetivo de converter arquivo xlsx em objetos
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 * @param <T>
 *
 */
public abstract class PoiParser<T> {
	
	protected static final String ENCRYPTED_DEFAULT_PASSWORD = "$2a$10$TH9WvYSs4BYDi7NaesV.Uerv7ZyzXXrEuriWeo2qAl96i6fN3oz8G";
	
	private static final Logger LOGGER = Logger.getLogger( PoiParser.class.getName() );
	
	protected abstract List<T> toObjectList(final InputStream inputStream) throws MapSkillsException;

	protected abstract T buildObject(final Iterator<Cell> cellIterator) throws MapSkillsException;
	/**
	 * O metodo <code>objectListFactory</code> converte um arquivo do tipo excel xlsx em uma lista de objetos.
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException 
	 * @throws MapSkillsException 
	 * @throws Exception
	 */
	protected List<T> objectListFactory(final InputStream inputStream) throws MapSkillsException {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(inputStream);
			final XSSFSheet sheet = workbook.getSheetAt(0);
			final Iterator<Row> rowIterator = sheet.iterator(); 
			workbook.close();
			return objectListBuilder(rowIterator);
		} catch (final Exception e) {
			LOGGER.info(e.getMessage());
			throw new ReadFileException(e);
		}
	}
	/**
	 * O metodo <code>objectListBuilder</code> auxilia o metodo <code>objectListFactory<code> na conversao
	 * de um arquivo em uma lista de objeto, iterando nas linhas do documento, sem pegar a primeira linha que
	 * sao os titulos das colunas.
	 * 
	 * @param rowIterator
	 * @return
	 * @throws MapSkillsException 
	 */
	private List<T> objectListBuilder(final Iterator<Row> rowIterator) throws MapSkillsException {
		final List<T> objectList = new ArrayList<>();
		Row row;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			if(row.getRowNum() == 0) {
				continue;
			}
			final Iterator<Cell> cellIterator = row.cellIterator();
			objectList.add(buildObject(cellIterator));
		}
		return objectList;
	}
	/**
	 * O metodo <code>objectArgs</code> perrcorre nas celulas da linha do arquivo e retorna uma lista de String,
	 * para ser usado como parametro em quem a chamou.
	 * 
	 * @param cellIterator
	 * @return
	 */
	protected List<String> getObjectArgs(final Iterator<Cell> cellIterator) {
		final List<String> args = new LinkedList<>();
		Cell cell;
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			args.add(cell.getStringCellValue());
		}
		return args;
	}

}
