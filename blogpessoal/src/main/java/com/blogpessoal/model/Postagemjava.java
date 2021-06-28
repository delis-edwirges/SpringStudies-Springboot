package com.blogpessoal.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_postagens")
public class Postagemjava {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao") // para nomear uma coluna
	private long id_postagem;

	@NotNull (message="O atributo título é obrigatório!")
	@Size(min=5, max=100, message="O atributo titulo deve conter no mínimo 5 carecteres e no máximo 100")
	@Column (name = "Titulo")
	private String titulo;
	
	
	@NotNull (message="O atributo texto é obrigatório!")
	@Size(min=10, max=2000, message="O atributo texto deve conter no mínimo 10 carecteres e no máximo 2000")
	@Column (name = "Texto")
	private String texto;
	
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "Momento_da_Postagem")
	private Date datatempo = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private TemaModel tema;
	
	public long getId_postagem() {
		return id_postagem;
	}
	public void setId_postagem(long id_postagem) {
		this.id_postagem = id_postagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Date getDatatempo() {
		return datatempo;
	}
	public void setDatatempo(Date datatempo) {
		this.datatempo = datatempo;
	}
	
	public TemaModel getTema() {
		return tema;
	}
	public void setTema(TemaModel tema) {
		this.tema = tema;
	}
	
	
}
