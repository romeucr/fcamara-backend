package br.com.fcamara.service.impl;

import br.com.fcamara.config.security.model.AuthenticatedUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.exception.AuthException;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.IAuthService;

import java.util.Optional;


@Service
public class AuthService implements IAuthService/*, UserDetailsService*/ {

/*
	private static Logger logger = LoggerFactory.getLogger(AuthService.class);
*/

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder pass;

	@Override
	public Boolean register(UserDTO userDTO) {
		try {
			ModelMapper mapper = new ModelMapper();
			UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
			userEntity.setPassword(pass.encode(userEntity.getPassword()));
			userRepository.save(userEntity);
			return true;
		} catch (Exception e) {
			throw new AuthException("Não foi possível criar o usuário.", HttpStatus.CONFLICT);
		}
	}

/*	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> userOptional = userRepository.findByEmail(username);

		if (userOptional.isEmpty()) {
			logger.error("Username not found: " + username);
			throw new UsernameNotFoundException("Username not found");
		}
		logger.info("Username found: " + username);
		return new AuthenticatedUser(userOptional.get());
	}*/
}
