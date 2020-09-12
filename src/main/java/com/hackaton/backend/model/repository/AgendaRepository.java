package com.hackaton.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackaton.backend.model.entity.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

}
