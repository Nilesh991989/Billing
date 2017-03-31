package com.ha.billing.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ha.billing.entity.BillingItem;
import com.ha.billing.mapper.BillingMapper;
import com.ha.billing.model.request.BillingItemRequest;
import com.ha.billing.model.response.BillingItemResponse;
import com.ha.billing.repository.BillingRepository;

@RestController
@RequestMapping(value="/api")
public class BillingController {
	
	@Autowired
	BillingRepository billingReppository;
	
	@RequestMapping(value="/save/bill",method=RequestMethod.POST)
	public BillingItem saveBilling(@RequestBody BillingItemRequest billingItem){
		BillingMapper mapper = new BillingMapper();
		BillingItem item = mapper.mapToBillingItem(billingItem);
	    return billingReppository.save(item);
	}
	
	@RequestMapping(value="/getbill/{name}",method=RequestMethod.GET)
	public List<BillingItemResponse> getAllBillByName(@PathVariable(value="name") String name){
	     List<BillingItem> listItem = billingReppository.findByNameStartingWith(name);
	     Collections.reverse(listItem);
	     BillingMapper mapper = new BillingMapper();
	     List<BillingItemResponse> billItemResponseList = new ArrayList<>();
	     listItem.stream().forEach(item -> billItemResponseList.add(mapper.mapToBillingItemResponse(item)));	     
	     return  billItemResponseList;
	}
	
}
