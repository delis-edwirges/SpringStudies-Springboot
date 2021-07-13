package com.gamestore.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.model.ClienteLogin;
import com.gamestore.model.ClienteModel;
import com.gamestore.repository.ClienteRepository;
import com.gamestore.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/all")
	public ResponseEntity<List<ClienteModel>> getAll() {
		return ResponseEntity.ok(clienteRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteModel> getById(@PathVariable long id){
		return clienteRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());				
	}

	@PostMapping("/logar")
	public ResponseEntity<ClienteLogin> autenticationUsuario(@RequestBody Optional<ClienteLogin> usuario) {
		return clienteService.logarCliente(usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<ClienteModel> postCliente(@RequestBody ClienteModel usuario) {
		Optional<ClienteModel> novoUsuario = clienteService.cadastrarCliente(usuario);
		try {
				return ResponseEntity.ok(novoUsuario.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<ClienteModel> putUsuario(@RequestBody ClienteModel usuario){
		Optional<ClienteModel> updateUsuario = clienteService.atualizarCliente(usuario);
		try {
			return ResponseEntity.ok(updateUsuario.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}

