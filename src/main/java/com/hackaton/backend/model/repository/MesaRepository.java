package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Integer> {

}
