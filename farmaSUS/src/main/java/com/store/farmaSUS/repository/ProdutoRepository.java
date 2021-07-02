package com.store.farmaSUS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.farmaSUS.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByProdutoContainingIgnoreCase(String produto);
	public List<Produto> findAll();
}