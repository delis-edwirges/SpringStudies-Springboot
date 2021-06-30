package com.blogpessoal.controller;

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

import com.blogpessoal.model.Postagemjava;
import com.blogpessoal.repository.PostagemRepository;

@RestController
@RequestMapping ("/postagens")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class PostagemController {
		@Autowired
		private PostagemRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Postagemjava>> GetAll (){
			return ResponseEntity.ok(repository.findAll()); // Se deu certo vai aparecer o 200
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Postagemjava>  GetOId(@PathVariable Long id){
			return repository.findById(id)
				.map(resp -> ResponseEntity.ok (resp))
				.orElse(ResponseEntity.notFound().build());
			}
		
		@GetMapping ("/titulo/{titulo}")              
		public ResponseEntity<List<Postagemjava>> GetByTitulo(@PathVariable String titulo){                   
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
			
		}
		
		@PostMapping
		public ResponseEntity<Postagemjava> postarPostagem (@RequestBody Postagemjava postagem){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		
		}
		
		@PutMapping
		public ResponseEntity<Postagemjava> putPostagem(@RequestBody Postagemjava postagem){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		
		}
		
		@DeleteMapping("/{id}")
		public void deletaPostagem (@PathVariable long id) {
			repository.deleteById(id);
		}
}
