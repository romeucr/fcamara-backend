package br.com.fcamara.handler;


import java.util.HashMap;
import java.util.Map;

import br.com.fcamara.exception.StandardError;
import br.com.fcamara.service.exceptions.ForbiddenException;
import br.com.fcamara.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import br.com.fcamara.exception.AuthException;
import br.com.fcamara.model.Response;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(AuthException.class)
	public ResponseEntity<Response<String>> handlerMateriaException(AuthException m) {
		Response<String> response = new Response();
		response.setStatusCode(m.getHttpStatus().value());
		response.setData(m.getMessage());
		response.setTimeStamp(System.currentTimeMillis());
		return ResponseEntity.status(m.getHttpStatus()).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Response<Map<String, String>>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m) {
		Map<String, String> erros = new HashMap<>();
		m.getBindingResult().getAllErrors().forEach((error) -> {
			String campo = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			erros.put(campo, mensagem);
		});

		Response<Map<String, String>> response = new Response<Map<String, String>>();
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setData(erros);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@ExceptionHandler(ForbiddenException.class)
		public ResponseEntity<StandardError> handlerForbiddenException(ForbiddenException e, HttpServletRequest request) {
			StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
		}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> handlerResourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
