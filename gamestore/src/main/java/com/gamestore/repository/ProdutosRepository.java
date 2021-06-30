package com.gamestore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamestore.model.ProdutosModel;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long>{

	public List<ProdutosModel> findAllByProdutoContainingIgnoreCase(String produto);
	public List<ProdutosModel> findAll();
}