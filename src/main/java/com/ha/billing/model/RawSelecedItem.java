package com.ha.billing.model;

public class RawSelecedItem {
	private String name;
	private String mrp;
	private String price;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
