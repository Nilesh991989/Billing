package com.ha.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ha.billing.service.ReportService;

@RestController
public class ReportController {
	
	@Autowired
	ReportService reportservice;
	
	@RequestMapping(value="/report/{startdate}/{enddate}", method=RequestMethod.GET)
	public void getReport(@PathVariable(value="startdate") String startdate,@PathVariable(value="enddate") String enddate ){
		reportservice.generateReport(startdate , enddate);				
	}
}
