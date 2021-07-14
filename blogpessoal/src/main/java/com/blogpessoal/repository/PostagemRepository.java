package com.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogpessoal.model.Postagem;



@Repository
@Transactional(readOnly = true)
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo);

	/**
	 * 
	 * Consulta Nativa - Conta o numero de postagens por tema
	 * 
	 */
	
	@Query(value = "select count(tema_numeracao) from tb_postagens where tema_numeracao = :id", nativeQuery = true)
	public int countPosts2(@Param("id") long id);

}