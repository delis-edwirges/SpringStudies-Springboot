package com.blogpessoal.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.model.Postagemjava;
@Repository
public interface PostagemRepository extends JpaRepository<Postagemjava, Long>{
	public List<Postagemjava> findAllByTituloContainingIgnoreCase(String titulo);
}
