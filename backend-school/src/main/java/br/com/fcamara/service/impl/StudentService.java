package br.com.fcamara.service.impl;

import br.com.fcamara.dto.StudentDTO;
import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.repository.IStudentRepository;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  private IStudentRepository studentRepository;

  @Transactional(readOnly = true)
  public StudentDTO findById(Long id) {
    Optional<StudentEntity> obj = studentRepository.findById(id);
    StudentEntity entity = obj.orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    return new StudentDTO(entity);
  }
}
