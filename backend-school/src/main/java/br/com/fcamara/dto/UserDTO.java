package br.com.fcamara.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {

	private Long id;
	
	@NotBlank(message = "Informe o seu nome completo.")
	private String nomeCompleto;

	@NotBlank(message = "Informe o seu e-mail.")
	@Email(message = "O e-mail precisa ser válido.")
	private String email;

	@NotBlank(message = "Informe a senha.")
	@Length(min = 3)
	private String senha;

	private boolean active = true;
}
