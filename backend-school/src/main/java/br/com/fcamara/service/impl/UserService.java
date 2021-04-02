package br.com.fcamara.service.impl;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private AuthService authService;

  @Transactional(readOnly = true)
  public UserDTO findById(Long id) {

    //usuário logado pode buscar somente o seu usuário.
    authService.validateSelf(id);

    Optional<UserEntity> obj = userRepository.findById(id);
    UserEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, UserDTO.class);
  }
}
