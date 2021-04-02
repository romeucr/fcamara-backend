package br.com.fcamara.service.impl;

import br.com.fcamara.dto.StateDTO;
import br.com.fcamara.entity.StateEntity;
import br.com.fcamara.repository.IStateRepository;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StateService {

  @Autowired
  private IStateRepository stateRepository;

  @Transactional(readOnly = true)
  public StateDTO findByAcronym(String acronym) {
    Optional<StateEntity> obj = stateRepository.findByAcronymIgnoreCase(acronym);
    StateEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Estado não encontrado"));
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, StateDTO.class);
  }

}
