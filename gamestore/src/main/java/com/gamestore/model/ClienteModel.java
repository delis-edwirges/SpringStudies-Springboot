package com.gamestore.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotNull
	@Size
	private String nomecompleto;
	
	@NotNull
	@Size
	private String usuario;
	
	@NotNull
	@Size
	private String senha;
	
	@NotNull
	@Size
	private LocalDate datanascimento;

}
