/* @(#)CellBlankException.java 1.0 05/02/2017
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;

public class CellBlankException extends MapSkillsException {

	private static final long serialVersionUID = 1L;
	
	private final int rowIndex;
	private final int columnIndex;
	
	public CellBlankException(final int rowIndex, final int columnIndex) {
		super(String.format("Celula em branco encontrada na linha %i, coluna %i", rowIndex, columnIndex));
		this.rowIndex = rowIndex;
		this.columnIndex = columnIndex;
	}
	
	public int getRowIndex() {
		return rowIndex;
	}
	
	public int getColumnIndex() {
		return columnIndex;
	}

}
