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

import com.hackaton.backend.dto.request.MesaRequestDTO;
import com.hackaton.backend.model.entity.Mesa;
import com.hackaton.backend.model.entity.Restaurante;
import com.hackaton.backend.model.repository.MesaRepository;
import com.hackaton.backend.model.repository.RestauranteRepository;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {
	

		private final MesaRepository mesaRepository;
		private final RestauranteRepository restauranteRepository;

		@Autowired
		public MesaController(MesaRepository mesaRepository, RestauranteRepository restauranteRepository) {
			this.mesaRepository = mesaRepository;
			this.restauranteRepository = restauranteRepository;
		}

		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Mesa salvar(@RequestBody MesaRequestDTO dto) {
			Restaurante restaurante = restauranteRepository.findById(dto.getFkRestaurante()).get();
			
			Mesa mesa = new Mesa();
			mesa.setFechada(dto.isFechada());
			mesa.setFkRestaurante(restaurante);
			mesa.setNumeroDaMesa(dto.getNumeroDaMesa());
			
			return mesaRepository.save(mesa);
		}

		@GetMapping("{id}")
		public Mesa encontrarPorId(@PathVariable Integer id) {
			return mesaRepository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));

		}

		@DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable Integer id) {
			mesaRepository.findById(id).map(mesa -> {
				mesaRepository.delete(mesa);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));
		}

		@PutMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void atualizar(@PathVariable Integer id, @RequestBody @Valid Mesa mesaAtualizado) {

			mesaRepository.findById(id).map(mesa -> {
				mesaAtualizado.setId(mesa.getId());
				return mesaRepository.save(mesaAtualizado);

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));
		}

	}