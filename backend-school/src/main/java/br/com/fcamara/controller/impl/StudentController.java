package br.com.fcamara.controller.impl;

import br.com.fcamara.dto.StudentDTO;
import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.service.impl.StudentService;
import br.com.fcamara.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping("/{id}")
  public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
    StudentDTO dto = studentService.findById(id);
    return ResponseEntity.ok().body(dto);
  }
}
