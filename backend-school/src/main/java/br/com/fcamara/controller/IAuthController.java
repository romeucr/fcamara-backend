package br.com.fcamara.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fcamara.dto.UserInsertDTO;
import br.com.fcamara.model.Response;

@RequestMapping("/auth")
public interface IAuthController {
	
<<<<<<< HEAD
	@PostMapping("/register")
	public ResponseEntity<Response<Boolean>> register(@Valid @RequestBody UserInsertDTO user);
=======
	@PostMapping("/register-donor")
	public ResponseEntity<Response<Boolean>> register(@Valid @RequestBody UserDTO user);
>>>>>>> 7e403eff19da498cd27425d181e33ec82408ab52

}
