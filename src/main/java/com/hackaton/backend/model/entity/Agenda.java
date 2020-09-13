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
public class Agenda extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "fk_cliente", nullable = false, referencedColumnName = "id")
	private Cliente fkCliente;

	@ManyToOne
	@JoinColumn(name = "fk_restaurante", nullable = false, referencedColumnName = "id")
	private Restaurante fkRestaurante;

	@Column(name = "hora_comeco", nullable = false)
	private Integer horaComeco;

	@Column(name = "hora_saida", nullable = false)
	private Integer horaSaida;

	@Column(name = "quantidade_pessoas", nullable = false)
	private Integer quantidadePessoas;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
}
