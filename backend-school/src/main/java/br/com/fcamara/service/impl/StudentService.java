package br.com.fcamara.service.impl;

import br.com.fcamara.dto.StudentDTO;
import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.exception.AuthException;
import br.com.fcamara.repository.IStudentRepository;
import br.com.fcamara.repository.ISupplyListItemRepository;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.exceptions.ForbiddenException;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private IStudentRepository studentRepository;

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private ISupplyListItemRepository supplyListItemRepository;

  @Transactional(readOnly = true)
  public StudentDTO findById(Long id) {
    Optional<StudentEntity> obj = studentRepository.findById(id);
    StudentEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    return new StudentDTO(entity);
  }

  @Transactional
  public void delete(Long id) {
    StudentDTO studentDTO = findById(id);

    //validando se o student é do mesmo usuario logado
    Optional<UserEntity> entity = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    UserEntity loggedUser = entity.orElseThrow(() ->
            new AuthException("É preciso estar logado para realizar esta operação", HttpStatus.FORBIDDEN));

    if (!loggedUser.getId().equals(studentDTO.getResponsible().getId())) {
      throw new ForbiddenException("O usuário logado não é responsável pelo aluno informado");
    }

    Long supplyListId = studentDTO.getSupplyListId();
    supplyListItemRepository.deleteSupplyListItemBySupplyListId(supplyListId);
    studentRepository.deleteById(id);

  }
}
