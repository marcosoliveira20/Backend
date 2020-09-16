package com.hackaton.backend.model.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hackaton.backend.dto.response.RestauranteResponseDTO;
import com.hackaton.backend.model.entity.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    Restaurante findByEmail(String email);

    List<Restaurante> findByNomeContains(String nome);
}
