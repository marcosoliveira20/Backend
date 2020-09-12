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

import com.hackaton.backend.model.entity.Mesa;
import com.hackaton.backend.model.repository.MesaRepository;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {
	

		private final MesaRepository repository;

		@Autowired
		public MesaController(MesaRepository repository) {
			this.repository = repository;
		}

		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Mesa salvar(@RequestBody @Valid Mesa mesa) {
			return repository.save(mesa);

		}

		@GetMapping("{id}")
		public Mesa encontrarPorId(@PathVariable Integer id) {
			return repository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));

		}

		@DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable Integer id) {
			repository.findById(id).map(mesa -> {
				repository.delete(mesa);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));
		}

		@PutMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void atualizar(@PathVariable Integer id, @RequestBody @Valid Mesa mesaAtualizado) {

			repository.findById(id).map(mesa -> {
				mesaAtualizado.setId(mesa.getId());
				return repository.save(mesaAtualizado);

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mesa não encontrado!"));
		}

	}