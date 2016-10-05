package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.gov.sp.fatec.mapskills.domain.User;
/**
 * A classe <code>UserXLSXParser</code> tem objetivo de converter arquivo xlsx em objetos
 * para serem persistidos no banco de dados.
 * 
 * @author Marcelo
 *
 */
public abstract class UserXLSXParser {
	
	protected abstract User buildUser(final Iterator<Cell> cellIterator);
	
	public List<User> toObject(final String path) throws IOException {
		final FileInputStream file = new FileInputStream(new File(path));
		final XSSFWorkbook workbook = new XSSFWorkbook(file);
		final XSSFSheet sheet = workbook.getSheetAt(0);
		final Iterator<Row> rowIterator = sheet.iterator();
		workbook.close();
		return userListBuilder(rowIterator);
	}

	private List<User> userListBuilder(final Iterator<Row> rowIterator) {
		final List<User> userList = new ArrayList<>();
		Row row;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			userList.add(buildUser(cellIterator));
		}
		return userList;
	}

}
