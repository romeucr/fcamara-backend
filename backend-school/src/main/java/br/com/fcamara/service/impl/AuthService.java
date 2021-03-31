package br.com.fcamara.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.exception.AuthException;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.IAuthService;


@Service
public class AuthService implements IAuthService {

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
			System.out.println("chegou aqui");
			return true;
		} catch (Exception e) {
			throw new AuthException("Não foi possível criar o usuário.", HttpStatus.CONFLICT);
		}
	}
}
