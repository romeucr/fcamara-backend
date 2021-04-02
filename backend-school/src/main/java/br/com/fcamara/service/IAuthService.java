package br.com.fcamara.service;

import br.com.fcamara.dto.UserInsertDTO;
import br.com.fcamara.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public interface IAuthService {
	public Boolean register(final UserInsertDTO userInsertDTO);

	@Transactional(readOnly = true)
	public UserEntity authenticated();

	//verifica se o usuário é o mesmo que está logado
	public void validateSelf(Long id);

}
