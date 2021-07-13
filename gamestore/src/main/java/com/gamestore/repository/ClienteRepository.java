package com.gamestore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestore.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	public List<ClienteModel> findAllByNomecompletoContainingIgnoreCase (String nomecompleto);
	
	public Optional<ClienteModel> findByUsuario(String usuario);
	
	public ClienteModel findByNomecompleto(String nomecompleto);

}
