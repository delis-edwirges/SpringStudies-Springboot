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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_temas")
public class TemaModel {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private long id_temas;
	

	@Column (name = "Tema")
	@NotNull (message="O atributo Descrição é obrigatório!")
	@Size(min=4, max=500, message="O atributo descrição deve conter no mínimo 4 carecteres e no máximo 500")
	private String descricao;
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<Postagemjava> postagem;

	public long getId_temas() {
		return id_temas;
	}

	public void setId_temas(long id_temas) {
		this.id_temas = id_temas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagemjava> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagemjava> postagem) {
		this.postagem = postagem;
	}
	
	
}
