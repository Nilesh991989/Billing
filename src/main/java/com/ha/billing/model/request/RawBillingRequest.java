package com.ha.billing.model.request;

import java.util.List;

import com.ha.billing.model.RawSelecedItem;
import com.ha.billing.model.SelectedItem;

public class RawBillingRequest {
	private String billid;
	private String name;
	private String date;
	private String pricewithvat;
	private List<RawSelecedItem> selectedItems;
	
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
	public String getPricewithvat() {
		return pricewithvat;
	}
	public void setPricewithvat(String pricewithvat) {
		this.pricewithvat = pricewithvat;
	}
	public List<RawSelecedItem> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<RawSelecedItem> selectedItems) {
		this.selectedItems = selectedItems;
	}	
}
