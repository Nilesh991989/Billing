package com.ha.billing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.billing.entity.Item;

@Transactional
public interface ItemRepository extends JpaRepository<Item, String> {
	public List<Item> findAll();
}
