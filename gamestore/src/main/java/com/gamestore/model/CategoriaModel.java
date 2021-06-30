package com.gamestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private Long id_categoria;
	
	@NotNull (message="O atributo Plataforma é obrigatório!")
	@Size(min=1, max=500, message="O atributo plataforma deve conter no mínimo 1 carecter e no máximo 500")
	private String plataforma;
	
	@NotNull (message="O atributo Produção é obrigatório!")
	@Size(min=1, max=500, message="O atributo produção deve conter no mínimo 1 carecter e no máximo 500")
	private String producao;
	
	@NotNull (message = "(Singleplayer|Multiplayer)")
	private Boolean jogadores;
	
	@NotNull (message = "(Online|Offline)")
	private Boolean conexao;
	
	@NotNull (message = "A Classificação Indicativa é Obrigatória")
	private Integer idade;

	public Long getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Long id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public Boolean getConexao() {
		return conexao;
	}

	public void setConexao(Boolean conexao) {
		this.conexao = conexao;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Boolean getJogadores() {
		return jogadores;
	}

	public void setJogadores(Boolean jogadores) {
		this.jogadores = jogadores;
	}

	
}
