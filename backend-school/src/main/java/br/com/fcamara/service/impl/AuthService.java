package br.com.fcamara.service.impl;

import br.com.fcamara.dto.UserInsertDTO;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.exception.AuthException;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.IAuthService;
import br.com.fcamara.service.exceptions.ForbiddenException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class AuthService implements IAuthService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder pass;

	@Override
	public Boolean register(UserInsertDTO userInsertDTO) {
		try {
			ModelMapper mapper = new ModelMapper();
			UserEntity userEntity = mapper.map(userInsertDTO, UserEntity.class);
			userEntity.setPassword(pass.encode(userEntity.getPassword()));
			userRepository.save(userEntity);
			return true;
		} catch (Exception e) {
			throw new AuthException("Não foi possível criar o usuário.", HttpStatus.CONFLICT);
		}
	}

	//Para retornar o usuário logado através do username validado pelo Spring Security
	@Override
	public UserEntity authenticated() {
		//pegando o username do usuário autenticado pelo Spring Security
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Optional<UserEntity> userAuthenticated = userRepository.findByEmail(username);

		if (userAuthenticated.isPresent()) {
			return userAuthenticated.get();
		} else {
			throw new AuthException("Usuário inválido", HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public void validateSelf(Long userId) {
		UserEntity user = authenticated();
		if (!user.getId().equals(userId)) {
			throw new ForbiddenException("Acesso negado");
		}
	}
}
