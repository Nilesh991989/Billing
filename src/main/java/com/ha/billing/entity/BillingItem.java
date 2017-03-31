package com.ha.billing.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billhistory")
public class BillingItem {	
	@Id
	@GeneratedValue
	private String billid;
	@Column
	private String date;
	@Column
	private String name;		
	@Column
	private String pricewithoutvat;
	@Column
	private String pricewithvat;
	@Column
	private String totalvatamt;	
	@Column
	private String selectitem;	
	@Column
	private String discountRate;
	@Column
	private String discountAmt;
	
	
	public String getSelectitem() {
		return selectitem;
	}
	public void setSelectitem(String selectitem) {
		this.selectitem = selectitem;
	}
	public String getBillid() {
		return billid;
	}
	public void setBillid(String billid) {
		this.billid = billid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPricewithoutvat() {
		return pricewithoutvat;
	}
	public void setPricewithoutvat(String pricewithoutvat) {
		this.pricewithoutvat = pricewithoutvat;
	}
	public String getPricewithvat() {
		return pricewithvat;
	}
	public void setPricewithvat(String pricewithvat) {
		this.pricewithvat = pricewithvat;
	}	
	public String getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(String discountRate) {
		this.discountRate = discountRate;
	}
	public String getDiscountAmt() {
		return discountAmt;
	}
	public void setDiscountAmt(String discountAmt) {
		this.discountAmt = discountAmt;
	}
	public String getTotalvatamt() {
		return totalvatamt;
	}
	public void setTotalvatamt(String totalvatamt) {
		this.totalvatamt = totalvatamt;
	}
}
 