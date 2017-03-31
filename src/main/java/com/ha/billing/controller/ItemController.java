package com.ha.billing.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ha.billing.entity.Item;
import com.ha.billing.repository.ItemRepository;


@RestController
@RequestMapping(value="/api")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public List<Item> getAllItems(){
		Comparator<Item> byName= (Item i1, Item i2) -> i1.getName().compareTo(i2.getName());
		List<Item> sortedItemList = itemRepository.findAll();
		sortedItemList.sort(byName);
		return sortedItemList;		
	}
	
	@RequestMapping(value="/add/item", method=RequestMethod.POST)
	public void addorupdateItem(@RequestBody List<Item> listOfItem){
		listOfItem.stream().forEach(item -> itemRepository.save(item));
	}
	
	@RequestMapping(value="/delete/item", method=RequestMethod.POST)
	public void deleteItem(@RequestBody List<Item> listOfItem){
		listOfItem.stream().forEach(item -> itemRepository.delete(item));
	}
	
}
