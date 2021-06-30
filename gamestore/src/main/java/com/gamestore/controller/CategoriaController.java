package com.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	

}
