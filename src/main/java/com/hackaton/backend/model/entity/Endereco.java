package com.hackaton.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.backend.config.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "agenda")
@Data
public class Endereco extends AbstractEntity {

	@Column(name = "rua", nullable = false, length = 250)
	private String rua;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "bairro", nullable = false, length = 50)
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "fk_restaurante", referencedColumnName = "id")
	private Restaurante fkRestaurante;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
}
