package com.hackaton.backend.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.backend.config.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cliente  extends AbstractEntity {
	
	
	@Column(name = "nome", nullable = false, length = 150)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@Column(name = "senha", nullable = false, length = 150)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String senha;

	@Column(name = "email", nullable = false, length = 150, unique = true)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String email;

	@Column(name = "telefone", nullable = false, length = 11)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String telefone;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
}
	
	
