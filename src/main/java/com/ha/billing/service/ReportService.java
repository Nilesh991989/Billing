package com.ha.billing.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.billing.entity.BillingItem;
import com.ha.billing.repository.BillingRepository;
import com.sun.xml.txw2.annotation.XmlElement;

@Service
public class ReportService {
	@Autowired
	BillingRepository billingRepository;

	public void generateReport(String startdate, String enddate) {
		generateFolder();
		List<BillingItem> listofbillingitem =  billingRepository.findAll();
		generateFile(listofbillingitem);
	}

	private void generateFile(List<BillingItem> listofbillingitem) {		
		String report = System.getProperty("user.home") + "\\Desktop\\GST Report\\ThirthankarAgencies_Report.xml";
		try {
			Path path = Files.createFile(Paths.get(report));
			BillingItemList billingitemlist = new BillingItemList();
			billingitemlist.setListofbillingitem(listofbillingitem);
			
			FileOutputStream outputStream = new FileOutputStream(report);
			JAXBContext jaxbContext = JAXBContext.newInstance(BillingItemList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(billingitemlist, path.toFile());
			outputStream.close();
		} catch (IOException | JAXBException e) {
			throw new RuntimeException("Exception while writing report to file",e);
		}		
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
		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).toString();
		
	}
	
	public String formatDate(String date){
		Date formattedDate;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss.s");
			formattedDate = simpleDateFormat.parse(date);
			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			return simpleDateFormat1.format(formattedDate);
		} catch (ParseException e) {
			throw new RuntimeException("Error while parsing date ",e);
		}
		
	}
}

@XmlRootElement
class BillingItemList{
	private List<BillingItem> listofbillingitem;

	public List<BillingItem> getListofbillingitem() {
		return listofbillingitem;
	}
	@XmlElement	
	public void setListofbillingitem(List<BillingItem> listofbillingitem) {
		this.listofbillingitem = listofbillingitem;
	}	
}