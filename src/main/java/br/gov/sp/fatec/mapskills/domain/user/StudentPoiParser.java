/* @(#)StudentXLSXParser.java 1.0 05/10/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.domain.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.utils.PoiParser;
/**
 * A classe <code>StudentXLSXParser</code> converte um arquivo xlsx em objetos do tipo Student
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class StudentPoiParser extends PoiParser {
	/**
	 * O método <code>toObjectList</code> converte um arqiuvo do tipo excel xlsx em uma
	 * lista de objetos do tipo Student.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Student> toObjectList(final InputStream inputStream) throws Exception {
		final List<Student> studentList = new ArrayList<>();
		studentList.addAll((List<Student>) super.objectListFactory(inputStream));
		return studentList;
	}
	/**
	 * O método <code>build</code> constroi um objeto do tipo Student a partir de uma lista de
	 * String devolvida da chamada do método <code>objectArgs</code>.
	 */
	protected Student build(final Iterator<Cell> cellIterator) {
		final List<String> args = super.objectArgs(cellIterator);
		return new Student(args.get(1), new Integer(args.get(0)), args.get(3), 0, args.get(2), "Mudar@123");
	}

}
