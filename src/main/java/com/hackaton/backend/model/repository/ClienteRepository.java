package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
