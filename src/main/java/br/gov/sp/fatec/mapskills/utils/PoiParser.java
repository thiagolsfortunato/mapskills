/*
 * @(#)PoiParser.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec Jessen Vidal. All rights reserved. Fatec Jessen Vidal
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
 *
 */
public abstract class PoiParser {
	
	protected abstract List<?> toObjectList(final InputStream inputStream) throws Exception;

	protected abstract Object build(final Iterator<Cell> cellIterator) throws MapSkillsException;
	/**
	 * O método <code>objectListFactory</code> converte um arquivo do tipo excel xlsx em uma lista de objetos.
	 * 
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	protected List<?> objectListFactory(final InputStream inputStream) throws Exception {
		final XSSFWorkbook workbook = new XSSFWorkbook(inputStream); 
		final XSSFSheet sheet = workbook.getSheetAt(0);
		final Iterator<Row> rowIterator = sheet.iterator(); 
		workbook.close();
		return objectListBuilder(rowIterator);
	}
	/**
	 * O método <code>objectListBuilder</code> auxilia o método <code>objectListFactory<code> na conversão
	 * de um arquivo em uma lista de objeto, iterando nas linhas do documento, sem pegar a primeira linha que
	 * são os titulos das colunas.
	 * 
	 * @param rowIterator
	 * @return
	 * @throws MapSkillsException 
	 */
	private List<?> objectListBuilder(final Iterator<Row> rowIterator) throws MapSkillsException {
		final List<Object> objectList = new ArrayList<>();
		Row row;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			if(row.getRowNum() == 0) continue;
			final Iterator<Cell> cellIterator = row.cellIterator(); 
			objectList.add(build(cellIterator));
		}
		return objectList;
	}
	/**
	 * O método <code>objectArgs</code> perrcorre nas celulas da linha do arquivo e retorna uma lista de String,
	 * para ser usado como parametro em quem a chamou.
	 * 
	 * @param cellIterator
	 * @return
	 */
	protected List<String> objectArgs(final Iterator<Cell> cellIterator) {
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
