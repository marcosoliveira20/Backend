package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Endereco;
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
