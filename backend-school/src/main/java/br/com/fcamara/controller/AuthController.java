package br.com.fcamara.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fcamara.dto.UserDTO;
import br.com.fcamara.entity.UserEntity;
import br.com.fcamara.model.Response;
import br.com.fcamara.repository.IUserRepository;
import br.com.fcamara.service.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
	private IAuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<Response<Boolean>> register(@Valid @RequestBody UserDTO user) {
		Response<Boolean> response = new Response<>();
		response.setData(this.authService.register(user));
		response.setStatusCode(HttpStatus.CREATED.value());
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}
