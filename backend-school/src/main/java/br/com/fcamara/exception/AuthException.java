package br.com.fcamara.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
	private static final long serialVersionUID = -6279380875598771181L;
	
	private final HttpStatus httpStatus;
	
	public AuthException(final String msg, final HttpStatus httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
	}
	

}
