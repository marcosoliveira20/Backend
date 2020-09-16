package com.hackaton.backend.rest;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hackaton.backend.dto.request.AgendaRequestDTO;
import com.hackaton.backend.model.entity.Agenda;
import com.hackaton.backend.model.entity.Cliente;
import com.hackaton.backend.model.entity.Restaurante;
import com.hackaton.backend.model.repository.AgendaRepository;
import com.hackaton.backend.model.repository.ClienteRepository;
import com.hackaton.backend.model.repository.RestauranteRepository;;



@RestController
@RequestMapping("/api/agendas")
public class AgendaController {
	
	private final AgendaRepository agendaRepository;

	private final ClienteRepository clienteRepository;

	private final RestauranteRepository restauranteRepository;
	
	@Autowired
	public AgendaController(AgendaRepository agendaRepository, RestauranteRepository restauranteRepository ,  ClienteRepository clienteRepository) {
		this.agendaRepository = agendaRepository;
		this.clienteRepository = clienteRepository;
		this.restauranteRepository =restauranteRepository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Agenda salvar (@RequestBody @Valid AgendaRequestDTO dto) {
	
			Cliente cliente = clienteRepository.findById(dto.getFkCliente()).get();
			Restaurante restaurante = restauranteRepository.findById(dto.getFkCliente()).get();
			
			Agenda agenda = new Agenda();
			agenda.setFkCliente(cliente);
			agenda.setFkRestaurante(restaurante);
			agenda.setHoraComeco(dto.getHoraComeco());
			agenda.setHoraSaida(dto.getHoraComeco());
			agenda.setQuantidadePessoas(dto.getQuantidadePessoas());
			
			return agendaRepository.save(agenda);	
	
	}
	
	@GetMapping
	public List<Agenda> encontrarPorId(@RequestParam String nome) {
		return agendaRepository.findByHoraComecoContains(nome);
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable Integer id) {
		agendaRepository.findById(id)
		.map( agenda -> {
			agendaRepository.delete(agenda);
			return Void.TYPE;
		}		
				)
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrado!"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody @Valid Agenda agendaAtualizado ) {
		
		agendaRepository.findById(id)
		.map( agenda -> {
			agendaAtualizado.setId(agenda.getId());
			return agendaRepository.save(agendaAtualizado);
			 
		}		
				)
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrado!"));
	}

}