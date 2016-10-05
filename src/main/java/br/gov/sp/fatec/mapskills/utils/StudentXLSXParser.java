/* @(#)MapSkillsController.java 1.0 05/10/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.domain.User;
import br.gov.sp.fatec.mapskills.domain.student.Student;
/**
 * A classe <code>StudentXLSXParser</code> converte um arquivo xlsx em objetos do tipo Student
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class StudentXLSXParser extends UserXLSXParser {
	
	protected User buildUser(final Iterator<Cell> cellIterator) {
		final String[] obj = new String[4];
		Cell cell;
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			obj[cell.getColumnIndex()] = cell.getStringCellValue();
		}
		return new Student(obj[1], new Integer(obj[0]), obj[3], new Integer("1"), obj[2], "Mudar@123");
					/*.ra(obj[0])
					.name(obj[1])
					.email(obj[2])
					.phone(obj[3]);*/
	}

}
