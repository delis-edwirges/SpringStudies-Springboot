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
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao") // para nomear uma coluna
	private long id;

	@NotNull (message="O atributo título é obrigatório!")
	@Size(min=5, max=100, message="O atributo titulo deve conter no mínimo 5 carecteres e no máximo 100")
	@Column (name = "Titulo")
	private String titulo;
	
	
	@NotNull (message="O atributo texto é obrigatório!")
	@Size(min=10, max=2000, message="O atributo texto deve conter no mínimo 10 carecteres e no máximo 2000")
	@Column (name = "Texto")
	private String texto;
	
	
	@Temporal(TemporalType.TIMESTAMP)         
	private Date datatempo = new java.sql.Date(System.currentTimeMillis());
	
	@PositiveOrZero
	private int curtidas;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Usuario usuario;
	

	

	
}
