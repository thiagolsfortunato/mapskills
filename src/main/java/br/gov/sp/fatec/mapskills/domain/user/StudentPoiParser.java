/* @(#)StudentPoiParser.java 1.0 03/11/2016
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

import br.gov.sp.fatec.mapskills.application.MapSkillsException;
import br.gov.sp.fatec.mapskills.utils.PoiParser;
/**
 * A classe <code>StudentPoiParser</code> converte um arquivo xlsx em objetos do tipo Student
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
	 * @throws MapSkillsException 
	 */
	protected Student buildObject(final Iterator<Cell> cellIterator) throws MapSkillsException {
		final List<String> args = super.getObjectArgs(cellIterator);
		return new Student(academicRegistry(args.get(0)), args.get(1), args.get(2), args.get(3), "mudar@123");
	}
	
	/**
	 * método <code>academicRegistry</code> que retorna uma instancia de ra para o aluno.
	 * @param ra
	 * @return
	 * @throws MapSkillsException
	 */
	private AcademicRegistry academicRegistry(final String ra) throws MapSkillsException {
		raValidator(ra);
		final String institutionCode = ra.substring(0, 3);
		final String courseCode = ra.substring(3, 6);
		return new AcademicRegistry(ra, institutionCode, courseCode);
	}

	//verificar o ra se nao ha nenhuma divergencia e se atente todos requisitos necessarios
	//ver lista de verify de JWT do prof
	/**
	 * Método que válida o ra contido no documento xlsx
	 * @param ra
	 * @throws MapSkillsException
	 */
	private void raValidator(final String ra) throws MapSkillsException {
		try {
			Long.parseLong(ra);
			if(ra.length() < 13) throw new RAInvalidException(ra);
		} catch (final NumberFormatException e) {
			throw new RAInvalidException(ra);
		}
	}
	
}
