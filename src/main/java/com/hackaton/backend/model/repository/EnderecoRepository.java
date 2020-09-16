package com.hackaton.backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Cliente;
import com.hackaton.backend.model.entity.Endereco;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	List<Cliente> findByRuaContains(String rua);

}
