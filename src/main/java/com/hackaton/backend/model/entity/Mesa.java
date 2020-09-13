package com.hackaton.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hackaton.backend.config.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "mesa")
@Data
public class Mesa extends AbstractEntity {

	@Column(name = "numero_mesa", nullable = false)
	@NotEmpty(message = "{campo.numeroMesa.obrigatorio}")
	private String numeroDaMesa;

	@Column(name = "fechada")
	private boolean fechada;

	@ManyToOne
	@JoinColumn(name = "fk_restaurante", nullable = false, referencedColumnName = "id")
	@NotEmpty(message = "{campo.restaurante.obrigatorio}")
	private Restaurante fkRestaurante;

	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
