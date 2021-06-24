package com.helloworld.hello.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping
	public String hello() {
		return "<h1><font face=\"Verdana\">"
				+ "<p1 style=\"color:#FF0000\">Hell</p1>"
				+ "<p1 style=\"color:#FF8C00\">o</p1>"
				+ "<p1 style=\"color:#FFFF00\"> W</p1>"
				+ "<p1 style=\"color:#008000\">o</p1>"
				+ "<p1 style=\"color:#1E90FF\">r</p1>"
				+ "<p1 style=\"color:#00008B\">l</p1>"
				+ "<p1 style=\"color:#8B008B\">d</p1>"
				+ "! =)</h1>"
				+ "<p style=\"color:#FF1493\">Para fazer essa atividade, utilizei <strong>Persistência</strong> e <strong>Mentalidade de Crescimento</strong> :D</font></p>";
	}
}
