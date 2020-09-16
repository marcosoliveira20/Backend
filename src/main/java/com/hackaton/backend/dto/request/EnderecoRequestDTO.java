package com.hackaton.backend.dto.request;

import com.hackaton.backend.model.entity.Endereco;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoRequestDTO {

	private String rua;

	private String bairro;

	private Integer numero;

	private Integer fkRestaurante;

	public Endereco build() {
		Endereco endereco = new Endereco().setBairro(bairro).setNumero(numero).setRua(rua);
		endereco.setFkRestaurante(null);
		return endereco;
	}

}
