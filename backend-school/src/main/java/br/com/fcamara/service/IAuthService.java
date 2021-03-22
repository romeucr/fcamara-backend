package br.com.fcamara.service;

import br.com.fcamara.dto.UserDTO;

public interface IAuthService {
	public Boolean register(final UserDTO userDTO);

}
