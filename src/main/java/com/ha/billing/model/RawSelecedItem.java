package com.ha.billing.model;

public class RawSelecedItem {
	private String name;
	private String mrp;
	private String newprice;
	private String quantity;		
	private String pricewithvat;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getNewprice() {
		return newprice;
	}
	public void setNewprice(String newprice) {
		this.newprice = newprice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPricewithvat() {
		return pricewithvat;
	}
	public void setPricewithvat(String pricewithvat) {
		this.pricewithvat = pricewithvat;
	}	
}
