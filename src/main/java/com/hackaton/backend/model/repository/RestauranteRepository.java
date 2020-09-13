package com.hackaton.backend.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackaton.backend.model.entity.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
    @Query("select r from Restaurante r where r.email = :email")
    Restaurante existsByEmail(@Param("email") String email);
    
    @Query(" select r from Restaurante r  where upper(r.nome) like upper( :nome )" )
    List<Restaurante> findByNome(
            @Param("nome") String nome);

}
