package com.ha.billing.model.response;

import java.util.List;

import com.ha.billing.model.SelectedItem;

public class BillingItemResponse {
	private String billid;
	private String name;
	private String date;
	private List<SelectedItem> selectedItems;
	private String finaldiscountamt;
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
	public List<SelectedItem> getSelectedItems() {
		return selectedItems;
	}
	public void setSelectedItems(List<SelectedItem> selectedItems) {
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
