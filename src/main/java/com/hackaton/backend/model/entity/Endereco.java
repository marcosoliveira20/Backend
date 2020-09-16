package com.hackaton.backend.model.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.hackaton.backend.config.AbstractEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Entity(name = "endereco")
@Data
@NoArgsConstructor
@Accessors(chain=true)
@EqualsAndHashCode(callSuper = true)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Endereco extends AbstractEntity  {

	@Column(name = "rua", nullable = false, length = 250)
	private String rua;

	@Column(name = "numero", nullable = false)
	private Integer numero;

	@Column(name = "bairro", nullable = false, length = 50)
	private String bairro;

	@ManyToOne(cascade = CascadeType.ALL)
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
