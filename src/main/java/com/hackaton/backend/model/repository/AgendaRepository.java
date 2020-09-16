package com.hackaton.backend.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.backend.model.entity.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
	
	List<Agenda> findByHoraComecoContains(String horaComeco);

}
