/* @(#)MapSkillsController.java 1.0 05/10/2016
 *
 * Copyright (c) 2016, Fatec-Jessen Vidal. All rights reserved.Fatec-Jessen Vidal 
 * proprietary/confidential. Use is subject to license terms.
 */
package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import br.gov.sp.fatec.mapskills.domain.student.Student;
/**
 * A classe <code>StudentXLSXParser</code> converte um arquivo xlsx em objetos do tipo Student
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public class StudentXLSXParser extends XLSXParser {

	@Override
	@SuppressWarnings("unchecked")
	public List<Student> toUserList(final File file) throws Exception {
		final List<Student> studentList = new ArrayList<>();
		studentList.addAll((List<Student>) super.userListFactory(file));
		return studentList;
	}
	
	protected Student buildUser(final Iterator<Cell> cellIterator) {
		final List<String> args = super.objectArgs(cellIterator);
		return new Student(args.get(1), new Integer(args.get(0)), args.get(3), null, args.get(2), "Mudar@123");
	}

}
