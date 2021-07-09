package com.gamestore.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteLogin {
private String nomecompleto;
private String usuario;
private String senha;
private LocalDate datanascimento;
private String token;
}
