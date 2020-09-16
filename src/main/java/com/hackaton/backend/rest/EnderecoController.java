package com.hackaton.backend.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hackaton.backend.dto.request.EnderecoRequestDTO;
import com.hackaton.backend.model.entity.Endereco;
import com.hackaton.backend.model.entity.Restaurante;
import com.hackaton.backend.model.repository.EnderecoRepository;
import com.hackaton.backend.model.repository.RestauranteRepository;


@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	

		private final EnderecoRepository enderecoRepository;
		private final RestauranteRepository restauranteRepository;
		
		@Autowired
		public EnderecoController(EnderecoRepository enderecoRepository, RestauranteRepository restauranteRepository) {
			this.enderecoRepository = enderecoRepository;
			this.restauranteRepository = restauranteRepository;
		}

		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Endereco salvar(@RequestBody  EnderecoRequestDTO dto) {
		
			Restaurante restaurante = restauranteRepository.findById(1).get();
			
			Endereco endereco = new Endereco ();
			endereco.setBairro(dto.getBairro());
			endereco.setNumero(dto.getNumero());
			endereco.setRua(dto.getRua());
			endereco.setFkRestaurante(restaurante);
			
			
			return enderecoRepository.save(endereco);

		}

		@GetMapping("{id}")
		public Endereco encontrarPorId(@PathVariable Integer id) {
				
			Endereco endereco = enderecoRepository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));
			
			return endereco;
		}

		@DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable Integer id) {
			enderecoRepository.findById(id).map(endereco -> {
				enderecoRepository.delete(endereco);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));
		}

		@PutMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void atualizar(@PathVariable Integer id, @RequestBody @Valid Endereco enderecoAtualizado) {

			enderecoRepository.findById(id).map(endereco -> {
				enderecoAtualizado.setId(endereco.getId());
				return enderecoRepository.save(enderecoAtualizado);

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));
		}

	}