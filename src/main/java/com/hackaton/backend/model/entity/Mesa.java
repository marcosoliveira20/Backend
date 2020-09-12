package com.hackaton.backend.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero_mesa",nullable = false)
	@NotEmpty(message = "{campo.numeroMesa.obrigatorio}")
	private String numeroDaMesa;
	
	@Column
	private boolean fechada;
	
	@Column(name="fk_restaurante",nullable = false)
	@NotEmpty(message = "{campo.restaurante.obrigatorio}")
	private String fkRestaurante;
	
	@Column(name="data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
	
	
}
