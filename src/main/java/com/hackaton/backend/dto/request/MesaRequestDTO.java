package com.hackaton.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MesaRequestDTO {
	
	private Integer fkRestaurante;
	
	private boolean fechada;
	
	private Integer numeroDaMesa;

}
