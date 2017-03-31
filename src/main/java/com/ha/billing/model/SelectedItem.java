package com.ha.billing.model;

public class SelectedItem {
	private String name;
	private String mrp;
	private String price;
	private String quantity;
	private String freeItem;
	private String pricewithoutvat;
	private String discountRate;
	private String discountAmt;
	private String vat;	
	private String vatamt;	
	private String pricewithvat;
		
	public String getFreeItem() {
		return freeItem;
	}
	public void setFreeItem(String freeItem) {
		this.freeItem = freeItem;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
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
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	public String getVatamt() {
		return vatamt;
	}
	public void setVatamt(String vatamt) {
		this.vatamt = vatamt;
	}
}
