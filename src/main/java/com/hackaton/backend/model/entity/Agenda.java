package com.hackaton.backend.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Entity
@Data
public class Agenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="fk_cliente", nullable = false)
	private Integer fkCliente;
	
	@Column(name="fk_restaurante", nullable = false)
	private Integer fkRestaurante;
	
	@Column(name="hora_comeco", nullable = false)
	private Integer horaComeco;
	
	@Column(name="hora_saida", nullable = false)
	private Integer horaSaida;
	
	@Column(nullable = false)
	private Integer quantidadePessoas;
	
	@Column(name="data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
	

}
