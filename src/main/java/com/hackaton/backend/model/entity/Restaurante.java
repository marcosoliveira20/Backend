package com.hackaton.backend.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackaton.backend.config.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "restaurante")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Restaurante  extends AbstractEntity {

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
	
	@OneToMany(mappedBy = "fkRestaurante" )
	@JsonBackReference
	private  List <Endereco> enderecos;
	
	@OneToMany(mappedBy = "fkRestaurante" )
	@JsonManagedReference
	private  List <Mesa> mesas;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

	public Restaurante(@NotEmpty(message = "{campo.nome.obrigatorio}") String nome,
			@NotEmpty(message = "{campo.email.obrigatorio}") String email,
			@NotEmpty(message = "{campo.senha.obrigatorio}") String senha, String horaAbertura, String horaFechamento,
			LocalDate dataCadastro) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
		this.dataCadastro = dataCadastro;
	}
	
	
}
