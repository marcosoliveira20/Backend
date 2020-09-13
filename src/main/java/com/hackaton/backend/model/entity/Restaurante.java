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
public class Restaurante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(nullable = false, length = 150, unique=true)
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private String email;
	
	
	@Column(nullable = false, length = 150)
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String senha;
	
	@Column(name="kf_endereco", nullable = false)
	private Integer fkEndereco;
	
	@Column(name="hora_abertura")
	private String horaAbertura;
	
	@Column(name="hora_fechamento")
	private String horaFechamento;

	
	
	@Column(name="data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	
	
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
