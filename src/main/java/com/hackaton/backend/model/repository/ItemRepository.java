package com.hackaton.backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.model.entity.Item;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Integer>{
	
	List<Item> findByNomeContains(String nome);

}
