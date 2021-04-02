package br.com.fcamara.config.security.service;

import br.com.fcamara.config.security.model.AuthenticatedUser;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findByEmail(username);
		if (user.isPresent()) {
			return new AuthenticatedUser(user.get());
		} else {
			throw new UsernameNotFoundException("Usuário não autenticado.");
		}
	}

}
