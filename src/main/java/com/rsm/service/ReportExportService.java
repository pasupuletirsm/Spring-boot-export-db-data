package com.rsm.service;

import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rsm.entity.Product;
import com.rsm.repository.ProductRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportExportService {

	@Autowired
	ProductRepository repository;

	public void exportDbToExcel(HttpServletResponse response) throws IOException {

		List<Product> productList = repository.findAll();

		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet sheet = workBook.createSheet();
		HSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("ProductName");
		row.createCell(2).setCellValue("Price");

		int rowIndex = 1;
		for (Product product : productList) {
			HSSFRow dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(product.getId());
			dataRow.createCell(1).setCellValue(product.getProductName());
			dataRow.createCell(2).setCellValue(product.getPrice());
			rowIndex++;
		}
		ServletOutputStream ops = response.getOutputStream();
		workBook.write(ops);
		workBook.close();
		ops.close();
	}

}
