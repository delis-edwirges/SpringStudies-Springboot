package com.store.farmaSUS.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
@Table (name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private Long id;
	
	@NotNull (message="O atributo Categoria é obrigatório!")
	@Size (min = 2, max = 300, message = "O atributo Categoria deve ter entre 2 e 300 caracteres")
	@Column (name = "Categoria")
	private String descricao;

	@OneToMany(mappedBy = "fk_categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fk_categoria")
	private List<Produto> fk_produto;
	
	

}

