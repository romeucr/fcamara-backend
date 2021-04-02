package br.com.fcamara.service.impl;

import br.com.fcamara.dto.SchoolDTO;
import br.com.fcamara.dto.StudentDTO;
import br.com.fcamara.entity.SchoolEntity;
import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.exception.AuthException;
import br.com.fcamara.repository.ISchoolRepository;
import br.com.fcamara.repository.IStudentRepository;
import br.com.fcamara.repository.ISupplyListItemRepository;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.exceptions.ForbiddenException;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

  @Autowired
  private ISchoolRepository schoolRepository;

  @Transactional(readOnly = true)
  public List<SchoolDTO> findByName(String name) {
    List<Optional<SchoolEntity>> listObj = schoolRepository.findByNameContainingIgnoreCase(name);
    List<SchoolEntity> listEntity = new ArrayList<>();
    List<SchoolDTO> listDTO = new ArrayList<>();

    for (Optional<SchoolEntity> school : listObj) {
      listEntity.add(school.orElseThrow(() -> new ResourceNotFoundException("Escola não encontrada")));
    }

    for (SchoolEntity entity : listEntity) {
      listDTO.add(new SchoolDTO(entity));
    }

    return listDTO;
  }

}
