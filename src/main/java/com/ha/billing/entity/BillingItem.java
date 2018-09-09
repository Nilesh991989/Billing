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
	private String name;
	@Column
	private String date;		
	@Column
	private String selectedItems;
	@Column
	private String finaldiscountamt;
	@Column
	private String finalPrice;
	
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
	public String getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}
	public String getFinaldiscountamt() {
		return finaldiscountamt;
	}
	public void setFinaldiscountamt(String finaldiscountamt) {
		this.finaldiscountamt = finaldiscountamt;
	}
	public String getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}	
	
}
 