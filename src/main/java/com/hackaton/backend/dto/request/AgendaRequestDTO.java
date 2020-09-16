package com.hackaton.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendaRequestDTO {
	
	private Integer fkCliente;
	
	private Integer fkRestaurante;
	
	private Integer horaComeco;

	private Integer horaSaida;

	private Integer quantidadePessoas;

}
