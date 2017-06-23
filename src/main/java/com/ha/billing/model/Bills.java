package com.ha.billing.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Bills {
	private List<Bill> bill;

	public List<Bill> getBill() {
		return bill;
	}
	
	@XmlElement
	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}
}
