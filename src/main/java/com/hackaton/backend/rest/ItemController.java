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

import com.hackaton.backend.dto.request.ItemRequestDTO;
import com.hackaton.backend.model.entity.Item;
import com.hackaton.backend.model.entity.Mesa;
import com.hackaton.backend.model.repository.ItemRepository;
import com.hackaton.backend.model.repository.MesaRepository;;



@RestController
@RequestMapping("/api/items")
public class ItemController {
	
	private final ItemRepository repositoryItem;
	
	private final MesaRepository repositoryMesa;
	
	@Autowired
	public ItemController(ItemRepository repositoryItem, MesaRepository repositoryMesa) {
		this.repositoryItem = repositoryItem;
		this.repositoryMesa = repositoryMesa;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public  Item salvar (@RequestBody @Valid ItemRequestDTO dto) {
		try {	
			
			Mesa mesa = repositoryMesa.findById(dto.getFkMesa()).get();
			Item item = new Item();
			
			item.setNome(dto.getNome());
			item.setPreco(dto.getPreco());
			item.setPronto(dto.isPronto());
			item.setFkMesa(mesa);
			
			return repositoryItem.save(item);
					
		}catch(Exception e) {
			throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Item já cadastrado" );
		}
	}
	
	@GetMapping
	public List<Item> encontrarPorId(@RequestParam String nome) {
		return repositoryItem.findByNomeContains( nome);
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable Integer id) {
		repositoryItem.findById(id)
		.map( item -> {
			repositoryItem.delete(item);
			return Void.TYPE;
		}		
				)
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado!"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Integer id, @RequestBody @Valid Item itemAtualizado ) {
		
		repositoryItem.findById(id)
		.map( item -> {
			itemAtualizado.setId(item.getId());
			return repositoryItem.save(itemAtualizado);
			 
		}		
				)
		.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado!"));
	}

}