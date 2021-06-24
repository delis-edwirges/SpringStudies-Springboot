package com.helloworld2.hello2.collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping ("/hello2")

public class Hello2Collector {
@GetMapping String hello2 (){
	return "<br>"
			+ "<font face=\"Verdana\"> <ul style=background-color:#FFDAB9;><strong> <h1>Objetivos para essa semana (23/06/2021):</h1></font></strong></ul>"
			+ "<ul style=background-color:#FFE4B5 align=\"left\">Aprender Springboot;</ul>"
			+ "<ul style=background-color:#FFFACD>Pesquisar mais nomes para o projeto;</ul>"
			+ "<ul style=background-color:#EEE8AA>Ir na base da persistência;</ul>"
			+ "<ul style=background-color:#E0FFFF>Revisar os códigos;</ul>"
			+ "<ul style=background-color:#B0E0E6>Ajudar e pedir ajuda;</ul>"
			+ "<ul style=background-color:#D8BFD8>Descansar;</ul></font>";
}
}
