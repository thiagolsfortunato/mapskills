/* @(#)InstitutionXLSXParser.java 1.0 05/10/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.utils.XLSXParser;
/**
 * A classe <code>InstitutionXLSXParser</code> converte um arquivo .xlsx em objetos do tipo Mentor
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class InstitutionXLSXParser extends XLSXParser {
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Institution> toObjectList(final File file) throws Exception {
		List<Institution> objectList = new ArrayList<>();
		objectList.addAll((List<Institution>) super.objectListFactory(file));
		return objectList;
	}

	@Override
	protected Institution build(final Iterator<Cell> cellIterator) {
		final List<String> args = super.objectArgs(cellIterator);
		return new Institution(args.get(0), args.get(1), args.get(2), new Mentor(args.get(3), args.get(4), args.get(5)));
	}

}
