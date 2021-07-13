package com.gamestore.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.gamestore.model.ClienteModel;
import com.gamestore.repository.ClienteRepository;





@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<ClienteModel> usuario = userRepository.findByUsuario(userName);
		usuario.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return usuario.map(UserDetailsImpl::new).get();
	}
}



