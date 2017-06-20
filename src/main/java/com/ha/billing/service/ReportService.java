package com.ha.billing.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.billing.entity.BillingItem;
import com.ha.billing.repository.BillingRepository;

@Service
public class ReportService {
	private HSSFWorkbook workbook;
	
	@Autowired
	BillingRepository billingRepository;

	public void generateReport(String startdate, String enddate) {
		generateFolder();
		HSSFSheet hssfsheet  = createHssfSheet();
		List<BillingItem> listofbillingitem =  billingRepository.findAll();
		generateFile(hssfsheet, listofbillingitem);
			}

	private void generateFile(HSSFSheet hssfsheet, List<BillingItem> listofbillingitem) {
		int rowcount = 0;
		Row row = hssfsheet.createRow(rowcount);
		row.createCell(0).setCellValue("Bill Id");
		row.createCell(1).setCellValue("Billing Date");
		row.createCell(2).setCellValue("Name");
		row.createCell(3).setCellValue("Price Without Vat");
		row.createCell(4).setCellValue("Total VAT");
		row.createCell(5).setCellValue("Total Price");
		rowcount++;
		for(BillingItem billingItem : listofbillingitem){
			Row billingitemrow = hssfsheet.createRow(rowcount);
			billingitemrow.createCell(0).setCellValue(billingItem.getBillid());
			billingitemrow.createCell(1).setCellValue(billingItem.getDate());
			billingitemrow.createCell(2).setCellValue(billingItem.getName());
			billingitemrow.createCell(3).setCellValue(formateCurrency(billingItem.getPricewithoutvat()));
			billingitemrow.createCell(4).setCellValue(formateCurrency(billingItem.getTotalvatamt()));
			billingitemrow.createCell(5).setCellValue(formateCurrency(billingItem.getPricewithvat()));
			rowcount++;
		}
		String report = System.getProperty("user.home") + "\\Desktop\\GST Report\\ThirthankarAgencies_Report.csv";
		try {
			FileOutputStream outputStream = new FileOutputStream(report);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			throw new RuntimeException("Exception while writing report to file",e);
		}		
	}

	private HSSFSheet createHssfSheet() {
		workbook = new HSSFWorkbook();
		return workbook.createSheet("Report");	
	}

	private void generateFolder() {
		try {
			String gstreportFolder = System.getProperty("user.home") + "\\Desktop\\GST Report";
			Path path = Paths.get(gstreportFolder);
			if(Files.notExists(path, LinkOption.NOFOLLOW_LINKS)){
				Files.createDirectory(path);
			}
		}catch (IOException e) {
			throw new RuntimeException("Error while creating folder",e);
		}		
	}
	
	private String formateCurrency(String amount){
		 return String.valueOf(Math.round(Double.valueOf(amount)));
	}
	
	public String formatDate(String date) throws ParseException{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date formattedDate = simpleDateFormat.parse(date);
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-mm-yyyy");
		return simpleDateFormat1.format(formattedDate);		
	}
}
