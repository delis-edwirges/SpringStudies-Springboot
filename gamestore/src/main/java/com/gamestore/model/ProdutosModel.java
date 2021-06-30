package com.gamestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class ProdutosModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private Long id_produtos;
	
	@NotNull (message= "O atributo Nome é obrigatório!")
	@Size(min=1, max=500, message="O atributo nome deve conter no mínimo 1 carecter e no máximo 500")
	@Column (name = "Nome")
	private String produto;
	
	@NotNull (message= "O atributo Preço é obrigatório!")
	private Double preco;
	
	@NotNull (message= "O atributo Estoque é obrigatório!")
	private Integer estoque;
	
	@NotNull (message= "O atributo Quantidade é obrigatório!")
	private Integer quantidade;
	
	@ManyToOne
	@JsonIgnoreProperties ("fk_produtos")
	private CategoriaModel fk_categoria;
	
	public Long getId_produtos() {
		return id_produtos;
	}
	public void setId_produtos(Long id_produtos) {
		this.id_produtos = id_produtos;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public CategoriaModel getFk_categoria() {
		return fk_categoria;
	}
	public void setFk_categoria(CategoriaModel fk_categoria) {
		this.fk_categoria = fk_categoria;
	}
	
	
}
