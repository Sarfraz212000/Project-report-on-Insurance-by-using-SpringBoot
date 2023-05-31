package in.ashokit.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenEntity;

@Component
public class Excelgenrator {

	public void genrateor(HttpServletResponse response,List<CitizenEntity> records,File file) throws IOException {

		Workbook book = new HSSFWorkbook();
		Sheet sheet = book.createSheet("plans-data");
		Row row = sheet.createRow(0);

		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CITIZEN NAME");
		row.createCell(2).setCellValue("PLAN NAME");
		row.createCell(3).setCellValue("PLAN STATUS");
		row.createCell(4).setCellValue("PLAN START DATE");
		row.createCell(5).setCellValue("PLAN END DATE");
		row.createCell(6).setCellValue("BENIFIT AMMOUNT");


		int datarowIndex = 1;
		for (CitizenEntity entity : records) {

			Row dataRow = sheet.createRow(datarowIndex);
			dataRow.createCell(0).setCellValue(entity.getCitizenId());
			dataRow.createCell(1).setCellValue(entity.getCitizenName());
			dataRow.createCell(2).setCellValue(entity.getPlanName());
			dataRow.createCell(3).setCellValue(entity.getPlanStatus());

			if (null != entity.getPlanStartDate()) {
				dataRow.createCell(4).setCellValue(entity.getPlanStartDate() + "");
			} else {
				dataRow.createCell(4).setCellValue("N/A");
			}
			if (null != entity.getPlanEndDate()) {
				dataRow.createCell(5).setCellValue(entity.getPlanEndDate() + "");
			} else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if (null != entity.getBenifitAmmount()) {
				dataRow.createCell(6).setCellValue(entity.getBenifitAmmount());
			} else {
				dataRow.createCell(6).setCellValue("N/A");
			}

			datarowIndex++;
		}
		
		
		
		  FileOutputStream files= new FileOutputStream(file);
		  book.write(files);
		  book.close();
		 
		
		ServletOutputStream outputStream = response.getOutputStream();
		book.write(outputStream);
		book.close();
	}

}
