package in.ashokit.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenEntity;

@Component
public class PdfGenrator {
	
	public void genrator(HttpServletResponse response,List<CitizenEntity> entities,File f) throws DocumentException, IOException
	{
		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Citizen Plan", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		PdfPTable table = new PdfPTable(7);

		// Setting width of table, its columns and spacing
		table.setSpacingBefore(5);

		table.addCell("ID");
		table.addCell("CITIZEN NAME");
		table.addCell("PLAN NAME");
		table.addCell("PLAN STATUS");
		table.addCell("PLAN START DATE");
		table.addCell("PLAN END DATE");
		table.addCell("BENIFIT AMMOUNT");


		for (CitizenEntity entity : entities) {

			table.addCell(String.valueOf(entity.getCitizenId()));
			table.addCell(entity.getCitizenName());
			table.addCell(entity.getPlanName());
			table.addCell(entity.getPlanStatus());
			if (null != entity.getPlanStartDate()) {
				table.addCell(entity.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != entity.getPlanEndDate()) {
				table.addCell(entity.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}
			if (null != entity.getBenifitAmmount()) {
				table.addCell(String.valueOf(entity.getBenifitAmmount()));

			} else {
				table.addCell("N/A");
			}

		}
		document.add(table);
		document.close();
	}

}
