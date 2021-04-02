package br.com.fcamara.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
				generator = ObjectIdGenerators.PropertyGenerator.class,
				property = "id")
public class UserDTO {

	private Long id;
	
	@NotBlank(message = "Informe o seu nome completo.")
	private String fullname;

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

	//private AddressDTO address;
	//private Set<StudentDTO> responsibleStudentList = new HashSet<>();
	//private Set<StudentDTO> donorStudentList = new HashSet<>();
}
