/* @(#)MapSkillsController.java 1.0 05/10/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.domain.User;
import br.gov.sp.fatec.mapskills.domain.institution.Institution;
import br.gov.sp.fatec.mapskills.domain.institution.Mentor;
/**
 * A classe <code>MentorXLSXParser</code> converte um arquivo xlsx em objetos do tipo Mentor
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class MentorXLSXParser extends UserXLSXParser {

	@Override
	protected User buildUser(final Iterator<Cell> cellIterator) {
		final String[] obj = new String[6];
		Cell cell;
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			obj[cell.getColumnIndex()] = cell.getStringCellValue();
		}
		return new Mentor(obj[0], obj[1], obj[2], new Institution(obj[3], obj[4], obj[5]));
	}

}
