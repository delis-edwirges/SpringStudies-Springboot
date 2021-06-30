package com.gamestore.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "tb_categoria")
public class CategoriaModel {
 private Long id_categoria;
 private String  plataforma;
 private String producao;
 private Boolean conexao;
 private Integer idade;

}
