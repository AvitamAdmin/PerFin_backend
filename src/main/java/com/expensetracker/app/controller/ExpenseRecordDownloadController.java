package com.expensetracker.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;

import com.expensetracker.app.dto.UserTotalExpenseData;
import com.expensetracker.app.service.PdfService;
import com.expensetracker.app.service.RecordSearchService;
import com.lowagie.text.DocumentException;

@RestController
public class ExpenseRecordDownloadController {
	@Autowired
	PdfService pdfService;
	@Autowired
	RecordSearchService recordSearchService;
	
	@GetMapping("/download/{userId}/{startDate}/{endDate}")
	public void  downloadExpenseData(HttpServletResponse response,@PathVariable String userId,@PathVariable String startDate,@PathVariable String endDate) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<UserTotalExpenseData> expenseData = recordSearchService.searchExpensesForThePeriod(startDate, endDate); 
        pdfService.setExpenseData(expenseData);
        pdfService.export(response);
	}
}
