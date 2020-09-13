package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackaton.backend.model.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
 
    @Query("select c from Cliente c where c.email = :email")
    Cliente existsByEmail(@Param("email") String email);

}
