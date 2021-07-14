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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private Long id;
	
	@NotNull (message = "O atributo nome não pode ser nulo.")
	@Size (min = 1, max = 300, message =" O nome deve ter entre 1 e 300 caracteres.")
	private String nome;
	
	@NotNull (message = "O atributo usuario não pode ser nulo.")
	@Size (min = 5, max = 180, message = "O email deve ter entre 5 a 180 caracteres. ")
	@Email
	private String usuario;
	
	@NotNull (message = "O atributo senha não pode ser nulo.")
	@Size (min = 5, message = "O atributo senha deve ter no mínimo 5 caracteres")
	private String senha;

	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Postagem> postagem;

}
