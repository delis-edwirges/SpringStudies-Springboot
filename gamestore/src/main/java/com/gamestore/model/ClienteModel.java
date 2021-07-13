package com.gamestore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table (name = "tb_clientes")
public class ClienteModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Numeracao")
	private Long id;
	
	@NotNull (message="O nome é obrigatório!")
	@Size (min=8 , max=300, message = "O nome deve conter no mínimo 8 caracteres")
	private String nomecompleto;
	
	@NotNull (message="O email é obrigatório!")
	@Size (min=6, message = "O email deve conter no mínimo 6 caracteres")
	@Email
	private String usuario;
	
	@NotNull (message="A senha é obrigatória!")
	@Size (min=4, message = "A senha deve conter no mínimo 4 caracteres")
	private String senha;
	
	@NotNull (message="A idade é obrigatória!")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column (name = "idade")
	private LocalDate datanascimento;

}
