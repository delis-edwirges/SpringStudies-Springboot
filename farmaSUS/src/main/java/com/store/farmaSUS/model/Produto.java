package com.store.farmaSUS.model;

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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Numeracao")
	private Long id_produtos;

	@NotNull(message = "O atributo Nome é obrigatório!")
	@Size(min = 1, max = 500, message = "O atributo nome deve conter no mínimo 1 carecter e no máximo 500")
	@Column(name = "Nome")
	private String produto;

	@NotNull(message = "O atributo Preço é obrigatório!")
	private Double preco;

	@NotNull(message = "O atributo Quantidade é obrigatório!")
	private Integer quantidade;

	@ManyToOne
	@JsonIgnoreProperties("fk_produtos")
	private Categoria fk_categoria;

}
