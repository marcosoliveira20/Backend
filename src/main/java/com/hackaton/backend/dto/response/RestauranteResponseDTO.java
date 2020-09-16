package com.hackaton.backend.dto.response;

import java.util.List;

import com.hackaton.backend.dto.request.EnderecoRequestDTO;
import com.hackaton.backend.model.entity.Endereco;
import com.hackaton.backend.model.entity.Restaurante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteResponseDTO {

	private String nome;
	private String senha;
	private String descricao;
	private String horaAbertura;
	private String horaFechamento;
	private List <Endereco> enderecos;
	
	
	public RestauranteResponseDTO(Restaurante restaurante) {
		
		this.nome = restaurante.getNome();
		this.senha = restaurante.getSenha();
		this.horaAbertura = restaurante.getHoraFechamento();
		this.horaFechamento = restaurante.getHoraFechamento();	
	
		for(int i=0; i <restaurante.getEnderecos().size(); i++) {
			EnderecoRequestDTO dto = new EnderecoRequestDTO();
			enderecos.set(i, dto.build()); ///dto.build(	restaurante.getEnderecos().get(i));
		}
		
	}
	
}
