package com.blogpessoal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioLogin {
	
	private String nome;
	private String usuario;
	private String senha;
	private String token;

}
