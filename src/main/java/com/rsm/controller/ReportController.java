package com.rsm.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rsm.service.ReportExportService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ReportController {

	@Autowired
	ReportExportService reportExportService;

	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws IOException {

		// response.setContentType("application/octet-stream");
		response.setContentType("application/vnd.ms-excel");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Product.xls";
		response.setHeader(headerKey, headerValue);

		reportExportService.exportDbToExcel(response);

	}

}
