package com.ha.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.billing.entity.BillingItem;

public interface BillingRepository extends JpaRepository<BillingItem,String>{
	
	public List<BillingItem> findByNameStartingWith(String name);
	
}
