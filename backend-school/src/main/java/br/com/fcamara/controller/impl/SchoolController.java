package br.com.fcamara.controller.impl;

import br.com.fcamara.dto.SchoolDTO;
import br.com.fcamara.dto.StudentDTO;
import br.com.fcamara.service.impl.SchoolService;
import br.com.fcamara.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

  @Autowired
  SchoolService schoolService;

  @GetMapping("/{name}")
  public ResponseEntity<List<SchoolDTO>> findByName(@PathVariable String name) {
    List<SchoolDTO> listDTO = schoolService.findByName(name);
    return ResponseEntity.ok().body(listDTO);
  }

}
