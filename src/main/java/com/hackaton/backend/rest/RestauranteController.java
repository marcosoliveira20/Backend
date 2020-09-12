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

import com.hackaton.backend.model.entity.Restaurante;
import com.hackaton.backend.model.repository.RestauranteRepository;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {
	

		private final RestauranteRepository repository;

		@Autowired
		public RestauranteController(RestauranteRepository repository) {
			this.repository = repository;
		}

		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Restaurante salvar(@RequestBody @Valid Restaurante restaurante) {
			return repository.save(restaurante);

		}

		@GetMapping("{id}")
		public Restaurante encontrarPorId(@PathVariable Integer id) {
			return repository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));

		}

		@DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable Integer id) {
			repository.findById(id).map(restaurante -> {
				repository.delete(restaurante);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));
		}

		@PutMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void atualizar(@PathVariable Integer id, @RequestBody @Valid Restaurante restauranteAtualizado) {

			repository.findById(id).map(restaurante -> {
				restauranteAtualizado.setId(restaurante.getId());
				return repository.save(restauranteAtualizado);

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurante não encontrado!"));
		}

	}

