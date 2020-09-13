package com.hackaton.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.backend.model.entity.Cliente;
import com.hackaton.backend.model.entity.Restaurante;
import com.hackaton.backend.model.repository.ClienteRepository;
import com.hackaton.backend.model.repository.RestauranteRepository;

@RestController
public class LoginController {

	private final ClienteRepository clienteRepository;

	private final RestauranteRepository restauranteRepository;

	@Autowired
	public LoginController(ClienteRepository clienteRepository, RestauranteRepository restauranteRepository) {
		this.clienteRepository = clienteRepository;
		this.restauranteRepository = restauranteRepository;
	}

	@RequestMapping("/api/clientes/login")
	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String loginCliente(@RequestBody Cliente email) {

		Cliente cliente = clienteRepository.existsByEmail(email.getEmail());
		try {
			if (cliente.getEmail() != null && cliente.getSenha() != null
					&& cliente.getSenha().equals(email.getSenha())) {
		
				return "{ 'autenticado': 'true' } ";
			}
			return "{ 'autenticado': 'false' } ";
		} catch (Exception e) {
			return "{ 'autenticado': 'false' } ";
		}
	}

	@RequestMapping("/api/restaurantes/login")
	@PostMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String loginRestaurante(@RequestBody Restaurante email) {

		Restaurante restaurante = restauranteRepository.existsByEmail(email.getEmail());
		try {
			if (restaurante.getEmail() != null && restaurante.getSenha() != null
					&& restaurante.getSenha().equals(email.getSenha())) {
		
				return "{ 'autenticado': 'true' } ";
			}
			return "{ 'autenticado': 'false' } ";
		} catch (Exception e) {
			return "{ 'autenticado': 'false' } ";
		}
	}
}
