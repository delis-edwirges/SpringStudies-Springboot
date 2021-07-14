package com.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tb_temas")
public class Tema {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private long id;
	

	@Column (name = "Tema")
	@NotNull (message="O atributo Descrição é obrigatório!")
	@Size(min=4, max=500, message="O atributo descrição deve conter no mínimo 4 carecteres e no máximo 500")
	private String descricao;
	
	@Transient
	private int qtdTema; 
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagem> postagem;

	
	
}
