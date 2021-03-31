package br.com.fcamara.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.fcamara.entity.UserEntity;
import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserInsertDTO {

	private Long id;

	@NotBlank(message = "Informe o seu e-mail.")
	@Email(message = "O e-mail precisa ser válido.")
	private String email;

	@NotBlank(message = "Informe a senha.")
	@Length(min = 3)
	private String password;

	private boolean active = true;

	@NotBlank(message = "Informe o seu nome completo.")
	private String name;

	@NotBlank(message = "Informe o seu cpf.")
	@CPF
	private String cpf;

	private Set<RoleDTO> roles = new HashSet<>();
}
