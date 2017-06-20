package com.ha.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.billing.entity.BillingItem;
import com.ha.billing.entity.RawBillingItem;

public interface RawBillingRepository extends JpaRepository<RawBillingItem,String>{
	
	public List<RawBillingItem> findByNameStartingWith(String name);
	
}
