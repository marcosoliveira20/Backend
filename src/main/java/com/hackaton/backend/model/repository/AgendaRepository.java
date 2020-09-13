package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Agenda;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

}
