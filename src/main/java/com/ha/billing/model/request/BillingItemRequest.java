package com.ha.billing.model.request;

import java.util.List;

import com.ha.billing.model.SelectedItem;

public class BillingItemRequest {
	private String billid;
	private String name;
	private String date;	
	private String pricewithoutvatanddiscount;
	private String pricewithvat;
	private String totalvatamt;	
	private List<SelectedItem> selectedItems;
		
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
	public String getPricewithoutvatanddiscount() {
		return pricewithoutvatanddiscount;
	}
	public void setPricewithoutvatanddiscount(String pricewithoutvatanddiscount) {
		this.pricewithoutvatanddiscount = pricewithoutvatanddiscount;
	}
	public String getPricewithvat() {
		return pricewithvat;
	}
	public void setPricewithvat(String pricewithvat) {
		this.pricewithvat = pricewithvat;
	}
	public List<SelectedItem> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<SelectedItem> selectedItems) {
		this.selectedItems = selectedItems;
	}
	public String getTotalvatamt() {
		return totalvatamt;
	}
	public void setTotalvatamt(String totalvatamt) {
		this.totalvatamt = totalvatamt;
	}
}
