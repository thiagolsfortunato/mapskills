/* @(#)InstitutionPoiParser.java 1.0 03/11/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.institution;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.utils.PoiParser;
/**
 * A classe <code>InstitutionXLSXParser</code> converte um arquivo .xlsx em objetos do tipo Mentor
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class InstitutionPoiParser extends PoiParser<Institution> {
	
	@Override
	public List<Institution> toObjectList(final InputStream inputStream) throws MapSkillsException {
		List<Institution> objectList = new ArrayList<>();
		objectList.addAll(super.objectListFactory(inputStream));
		return objectList;
	}

	@Override
	protected Institution buildObject(final Iterator<Cell> cellIterator) {
		final List<String> args = super.getObjectArgs(cellIterator);
		return new Institution(args.get(0), args.get(1), args.get(2), args.get(3), 
				new Mentor(args.get(4), args.get(0), args.get(5), ENCRYPTED_DEFAULT_PASSWORD));
	}

}
