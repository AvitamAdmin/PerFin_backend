package com.expensetracker.app.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.expensetracker.app.dto.UserTotalExpenseData;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

@Component
public class PdfService {
	private List<UserTotalExpenseData> expenseData;

	public List<UserTotalExpenseData> getExpenseData() {
		return expenseData;
	}

	public void setExpenseData(List<UserTotalExpenseData> expenseData) {
		this.expenseData = expenseData;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("User ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Category", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Amount", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Date", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		for (UserTotalExpenseData data : expenseData) {
			// String amount = new StringBuilder().append(data.getAmount()).toString();
			table.addCell(String.valueOf(data.getId()));
			table.addCell(data.getCategory());
			table.addCell(new StringBuilder().append(data.getAmount()).toString());
			table.addCell(data.getDate().toString());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Users", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 3,3,3,3 });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);

		document.close();

	}
}
