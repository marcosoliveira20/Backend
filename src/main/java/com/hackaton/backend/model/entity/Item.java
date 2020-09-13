package com.hackaton.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.backend.config.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Item extends AbstractEntity {

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "preco", nullable = false)
	private Double preco;

	@Column(name = "pronto", columnDefinition = "boolean default false")
	private boolean pronto;

	@ManyToOne
	@JoinColumn(name = "fk_mesa", nullable = false, referencedColumnName = "id")
	private Mesa fkMesa;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
