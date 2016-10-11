package br.gov.sp.fatec.mapskills.utils;

import java.io.File;
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
public abstract class XLSXParser {
	
	protected abstract List<?> toUserList(final File file) throws Exception;

	protected abstract User buildUser(final Iterator<Cell> cellIterator);

	protected List<? extends User> userListFactory(final File file) throws Exception {
		final XSSFWorkbook workbook = new XSSFWorkbook(file);
		final XSSFSheet sheet = workbook.getSheetAt(0);
		final Iterator<Row> rowIterator = sheet.iterator(); 
		workbook.close();
		return userListBuilder(rowIterator);
	}
		
	private List<? extends User> userListBuilder(final Iterator<Row> rowIterator) {
		final List<User> userList = new ArrayList<>();
		Row row;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			final Iterator<Cell> cellIterator = row.cellIterator();
			userList.add(buildUser(cellIterator));
		}
		return userList;
	}
	
	protected String[] objectArgs(final Iterator<Cell> cellIterator) {
		final String[] args = new String[this.size(cellIterator)];
		Cell cell;
		while (cellIterator.hasNext()) {
			cell = cellIterator.next();
			cell.setCellType(Cell.CELL_TYPE_STRING);
			args[cell.getColumnIndex()] = cell.getStringCellValue();
		}
		return args;
	}
	// DESCOBRIR TAMANHO DO ITERATOR, COMO FAZER CLONE DO ITERATOR?
	private int size(final Iterator<Cell> cellIterator) {
		int sizeValue = 0;
		final Iterator<Cell> iteratorCellTmp = cellIterator;
		while(iteratorCellTmp.hasNext()) {
			sizeValue++;
			cellIterator.next();
		}
		return sizeValue;
	}

}