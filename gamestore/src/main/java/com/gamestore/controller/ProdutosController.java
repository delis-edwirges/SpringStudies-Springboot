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

import com.gamestore.model.ProdutosModel;
import com.gamestore.repository.ProdutosRepository;



@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> GetAll (){
		return ResponseEntity.ok(produtosRepository.findAll()); // certo = 200
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutosModel> GetId (@PathVariable Long id){
	return produtosRepository.findById(id)
				.map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build()); 
		}
	

	@GetMapping ("/produto/{produto}")              
	public ResponseEntity<List<ProdutosModel>> GetByNome(@PathVariable String produto){                   
		return ResponseEntity.ok(produtosRepository.findAllByProdutoContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<ProdutosModel> postarProduto (@RequestBody ProdutosModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produto));
	
	}
	
	@PutMapping
	public ResponseEntity<ProdutosModel> putProduto(@RequestBody ProdutosModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produto));
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto (@PathVariable Long id) {
		produtosRepository.deleteById(id);
	}

}
