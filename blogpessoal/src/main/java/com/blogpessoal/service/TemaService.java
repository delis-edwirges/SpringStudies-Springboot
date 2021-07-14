package com.blogpessoal.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogpessoal.model.Tema;
import com.blogpessoal.repository.PostagemRepository;
import com.blogpessoal.repository.TemaRepository;

@Service
public class TemaService {

	@Autowired
	private TemaRepository temaRepository;
	
	@Autowired
	private PostagemRepository repository;
	

	public List<Tema> trendTopics(){
		
		List<Tema> temas = temaRepository.findAll();
		
		for (Tema tema : temas) {
	
			tema.setQtdTema(repository.countPosts2(tema.getId()));
		}
		
		Collections.sort(temas, Collections.reverseOrder(Comparator.comparing(Tema::getQtdTema)));
		return temas;
	}
}