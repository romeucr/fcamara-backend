package br.com.fcamara.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.model.Response;

@RequestMapping("/auth")
public interface IAuthController {
	
	@PostMapping("/register")
	public ResponseEntity<Response<Boolean>> register(@Valid @RequestBody UserDTO user);

}
