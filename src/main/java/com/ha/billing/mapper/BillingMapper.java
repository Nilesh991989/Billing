package com.ha.billing.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ha.billing.entity.BillingItem;
import com.ha.billing.entity.RawBillingItem;
import com.ha.billing.model.RawSelectedItems;
import com.ha.billing.model.SelectedItems;
import com.ha.billing.model.request.BillingItemRequest;
import com.ha.billing.model.request.RawBillingRequest;
import com.ha.billing.model.response.BillingItemResponse;
import com.ha.billing.model.response.RawBillingItemResponse;

public class BillingMapper {
	ObjectMapper objMapper = new ObjectMapper();
	
	public BillingItem mapToBillingItem(BillingItemRequest request){
		BillingItem item = new BillingItem();
		item.setDate(request.getDate());
		item.setName(request.getName());
		item.setPricewithoutvat(request.getPricewithoutvatanddiscount());
		item.setPricewithvat(request.getPricewithvat());
		item.setTotalvatamt(request.getTotalvatamt());
		SelectedItems selectedItems = new SelectedItems();
		selectedItems.setSelectedItems(request.getSelectedItems());
		item.setSelectitem(convertObjectToString(selectedItems));		
		return item;
	}
	
	public RawBillingItem mapToRawBillingItem(RawBillingRequest billingItem) {
		RawBillingItem item = new RawBillingItem();	
		item.setBillid(billingItem.getBillid());
		item.setDate(billingItem.getDate());
		item.setName(billingItem.getName());
		item.setPricewithvat(billingItem.getPricewithvat());
		RawSelectedItems rawselecteditems = new RawSelectedItems();
		rawselecteditems.setSelectedItems(billingItem.getSelectedItems());
		item.setSelectitem(convertObjectToString(rawselecteditems));
		return item;
	}

	private String convertObjectToString(Object obj) {
		try {
			return objMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error while mapping object",e);
		}
	}

	public BillingItemResponse mapToBillingItemResponse(BillingItem item) {
		BillingItemResponse response = new BillingItemResponse();
		response.setBillid(item.getBillid());
		response.setDate(item.getDate());
		response.setName(item.getName());
		response.setPricewithoutvat(item.getPricewithoutvat());
		response.setPricewithvat(item.getPricewithvat());
		response.setTotalvatamt(item.getTotalvatamt());
		try {
			SelectedItems selectedItems = objMapper.readValue(item.getSelectitem(), SelectedItems.class);
			response.setSelectedItems(selectedItems.getSelectedItems());
		} catch (Exception e) {
			throw new RuntimeException("Error while converting string to object",e);
		}
		return response;
	}

	public RawBillingItemResponse mapToRawBillingItemResponse(RawBillingItem item) {
		RawBillingItemResponse response = new RawBillingItemResponse();
		response.setBillid(item.getBillid());
		response.setDate(item.getDate());
		response.setName(item.getName());
		response.setPricewithvat(item.getPricewithvat());
		try{
			RawSelectedItems selectedItems = objMapper.readValue(item.getSelectitem(),RawSelectedItems.class);
			response.setSelectedItems(selectedItems.getSelectedItems());
		}catch(Exception e){
			
		}
		return response;
	}


}
