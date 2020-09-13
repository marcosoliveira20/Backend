package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Mesa;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {

}
