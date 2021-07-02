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

import com.store.farmaSUS.model.Produto;
import com.store.farmaSUS.repository.ProdutoRepository;



@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProdutoController{


	
	@Autowired
	private ProdutoRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll (){
		return ResponseEntity.ok(produtosRepository.findAll()); // certo = 200
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Produto> GetId (@PathVariable Long id){
	return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build()); 
		}
	

	@GetMapping ("/produto/{produto}")              
	public ResponseEntity<List<Produto>> GetByNome(@PathVariable String produto){                   
		return ResponseEntity.ok(produtosRepository.findAllByProdutoContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postarProduto (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
	
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto));
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto (@PathVariable Long id) {
		produtosRepository.deleteById(id);
	}

}
