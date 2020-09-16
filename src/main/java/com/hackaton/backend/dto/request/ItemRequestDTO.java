package com.hackaton.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemRequestDTO {
	
	private String nome;

	private Double preco;

	private boolean pronto;

	private Integer fkMesa;

}
