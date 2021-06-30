package com.gamestore.controller;

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


import com.gamestore.model.CategoriaModel;
import com.gamestore.repository.CategoriaRepository;



@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
		
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll (){
		return ResponseEntity.ok(categoriaRepository.findAll()); // certo = 200
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<CategoriaModel> GetId (@PathVariable Long id){
	return categoriaRepository.findById(id)
				.map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build()); 
		}
	

	@GetMapping ("/descricao/{descricao}")              
	public ResponseEntity<List<CategoriaModel>> GetByDescricao(@PathVariable String descricao){                   
		return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postarCategoria (@RequestBody CategoriaModel descricao){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(descricao));
	
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@RequestBody CategoriaModel descricao){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(descricao));
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria (@PathVariable Long id) {
		categoriaRepository.deleteById(id);
	}
}