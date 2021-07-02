package com.store.farmaSUS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.farmaSUS.model.Categoria;
import com.store.farmaSUS.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll (){
		return ResponseEntity.ok(repository.findAll()); // Se deu certo vai aparecer o 200
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Categoria>  GetOId(@PathVariable Long id){
		return repository.findById(id)
			.map(resp -> ResponseEntity.ok (resp))
			.orElse(ResponseEntity.notFound().build());
		}
	
	@GetMapping ("/descricao/{descricao}")              
	public ResponseEntity<List<Categoria>> GetByCategoria (@PathVariable String descricao){                   
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));	
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postarCategoria (@RequestBody Categoria descricao){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(descricao));
	
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria descricao){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(descricao));
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}
}

