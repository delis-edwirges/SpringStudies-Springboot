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

import com.blogpessoal.model.Tema;
import com.blogpessoal.repository.TemaRepository;
import com.blogpessoal.service.TemaService;

@RestController
@RequestMapping ("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temaRepository;

    @Autowired
   	private TemaService temaService;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll (){
		return ResponseEntity.ok(temaRepository.findAll()); // Se deu certo vai aparecer o 200
	}

	@GetMapping ("/{id}")
	public ResponseEntity<Tema>  GetOId(@PathVariable long id){
		return temaRepository.findById(id)
			.map(resp -> ResponseEntity.ok (resp))
			.orElse(ResponseEntity.notFound().build());
		}
	
	@GetMapping ("/descricao/{descricao}")              
	public ResponseEntity<List<Tema>> GetByTema(@PathVariable String descricao){                   
		return ResponseEntity.ok(temaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Tema> postarTema (@RequestBody Tema descricao){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(descricao));
	
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema descricao){
		return ResponseEntity.status(HttpStatus.OK).body(temaRepository.save(descricao));
	
	}
	
	@DeleteMapping("/{id}")
	public void deletaTema (@PathVariable long id) {
		temaRepository.deleteById(id);
	}
	
	@GetMapping("/trendtopics")
	public ResponseEntity<List<Tema>> getTrendTopics() {
		
		return ResponseEntity.ok(temaService.trendTopics());
	
	}
}