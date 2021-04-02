package br.com.fcamara.controller.impl;

import br.com.fcamara.dto.SchoolDTO;
import br.com.fcamara.dto.StateDTO;
import br.com.fcamara.service.impl.SchoolService;
import br.com.fcamara.service.impl.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

  @Autowired
  private StateService stateService;

  @GetMapping("/{acronym}")
  public ResponseEntity<StateDTO> findByAcronym(@PathVariable String acronym) {
    StateDTO dto = stateService.findByAcronym(acronym);
    return ResponseEntity.ok().body(dto);
  }

}
