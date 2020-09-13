package com.hackaton.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.backend.config.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "restaurante")
@Data
public class Restaurante extends AbstractEntity {

	@Column(name = "nome", nullable = false, length = 150)
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@Column(name = "email", nullable = false, length = 150, unique = true)
	@NotEmpty(message = "{campo.email.obrigatorio}")
	private String email;

	@Column(name = "senha", nullable = false, length = 150)
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String senha;

	@Column(name = "hora_abertura")
	private String horaAbertura;

	@Column(name = "hora_fechamento")
	private String horaFechamento;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
}
