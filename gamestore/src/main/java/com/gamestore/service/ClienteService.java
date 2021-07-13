package com.gamestore.service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gamestore.model.ClienteLogin;
import com.gamestore.model.ClienteModel;
import com.gamestore.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Optional<ClienteModel> cadastrarCliente(ClienteModel usuario) {
		
		if(clienteRepository.findByUsuario(usuario.getUsuario()).isPresent())
			throw new ResponseStatusException(
			          	HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
	
		int datanascimento = Period.between(usuario.getDatanascimento(), LocalDate.now()).getYears();
		
		if(datanascimento < 18)
			throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);
			
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		return Optional.of(clienteRepository.save(usuario));
	}

	
	public Optional<ClienteModel> atualizarCliente(ClienteModel usuario){
		
		if(clienteRepository.findById(usuario.getId()).isPresent()) {
			
			int datanascimento = Period.between(usuario.getDatanascimento(), LocalDate.now()).getYears();
			
			if(datanascimento < 18)
				throw new ResponseStatusException(
							HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);
			
			return Optional.of(clienteRepository.save(usuario));
		
		}else {
			
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
			
		}
		
	}
	public Optional<ClienteLogin> logarCliente(Optional<ClienteLogin> clienteLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<ClienteModel> usuario = clienteRepository.findByUsuario(clienteLogin.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(clienteLogin.get().getSenha(), usuario.get().getSenha())) {

				String auth = clienteLogin.get().getUsuario() + ":" + clienteLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				clienteLogin.get().setToken(authHeader);				
				clienteLogin.get().setNomecompleto(usuario.get().getNomecompleto());
				clienteLogin.get().setSenha(usuario.get().getSenha());
				
				return clienteLogin;

			}
		}

		throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
	}

}

