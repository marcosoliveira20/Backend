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

import com.hackaton.backend.model.entity.Endereco;
import com.hackaton.backend.model.repository.EnderecoRepository;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {
	

		private final EnderecoRepository repository;

		@Autowired
		public EnderecoController(EnderecoRepository repository) {
			this.repository = repository;
		}

		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Endereco salvar(@RequestBody @Valid Endereco endereco) {
			return repository.save(endereco);

		}

		@GetMapping("{id}")
		public Endereco encontrarPorId(@PathVariable Integer id) {
			return repository.findById(id)
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));

		}

		@DeleteMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void deletar(@PathVariable Integer id) {
			repository.findById(id).map(endereco -> {
				repository.delete(endereco);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));
		}

		@PutMapping("{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void atualizar(@PathVariable Integer id, @RequestBody @Valid Endereco enderecoAtualizado) {

			repository.findById(id).map(endereco -> {
				enderecoAtualizado.setId(endereco.getId());
				return repository.save(enderecoAtualizado);

			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereco não encontrado!"));
		}

	}