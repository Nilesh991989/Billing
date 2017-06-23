package com.ha.billing.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Bill {
	private String billid;
	private String date;
	private String name;
	private String pricewithoutvat;
	private String totalvatamt;
	private String pricewithvat;
	
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPricewithoutvat() {
		return pricewithoutvat;
	}
	public void setPricewithoutvat(String pricewithoutvat) {
		this.pricewithoutvat = pricewithoutvat;
	}
	public String getTotalvatamt() {
		return totalvatamt;
	}
	public void setTotalvatamt(String totalvatamt) {
		this.totalvatamt = totalvatamt;
	}
	public String getPricewithvat() {
		return pricewithvat;
	}
	public void setPricewithvat(String pricewithvat) {
		this.pricewithvat = pricewithvat;
	}		
}
