package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Integer>{

}
