package br.com.fcamara.controller.impl;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.dto.UserInsertDTO;
import br.com.fcamara.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
    UserDTO dto = userService.findById(id);
    return ResponseEntity.ok().body(dto);
  }
}
