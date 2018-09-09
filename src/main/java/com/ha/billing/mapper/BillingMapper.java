package com.ha.billing.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ha.billing.entity.BillingItem;
import com.ha.billing.model.SelectedItems;
import com.ha.billing.model.request.BillingItemRequest;
import com.ha.billing.model.response.BillingItemResponse;

public class BillingMapper {
	ObjectMapper objMapper = new ObjectMapper();
	
	public BillingItem mapToBillingItem(BillingItemRequest request){
		BillingItem item = new BillingItem();
		item.setDate(request.getDate());
		item.setName(request.getName());
		item.setFinaldiscountamt(request.getFinaldiscountamt());
		item.setFinalPrice(request.getFinalPrice());
		SelectedItems selectedItems = new SelectedItems();
		selectedItems.setSelectedItems(request.getSelectedItems());
		item.setSelectedItems(convertObjectToString(selectedItems));		
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
		response.setFinaldiscountamt(item.getFinaldiscountamt());
		response.setFinalPrice(item.getFinalPrice());
		try {
			SelectedItems selectedItems = objMapper.readValue(item.getSelectedItems(), SelectedItems.class);
			response.setSelectedItems(selectedItems.getSelectedItems());
		} catch (Exception e) {
			throw new RuntimeException("Error while converting string to object",e);
		}
		return response;
	}
}
