package br.com.fcamara.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="tb_user", indexes = { @Index(name = "email_idx", columnList = "email") }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "email", "cpf" }) })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends AbstractEntity implements Serializable {


	private static final long serialVersionUID = -904241684393606265L;

	@JsonInclude(Include.NON_EMPTY)
	private String name;

	private String cpf;

	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "email")
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String password;
	
	@Column(name = "is_active")
	private boolean active = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name = "tb_user_role",
					joinColumns = @JoinColumn(name = "user_id"),
					inverseJoinColumns = @ JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet<>();

	@OneToOne
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	@OneToMany(mappedBy="responsible", cascade=CascadeType.ALL)
	private Set<StudentEntity> responsibleStudentList = new HashSet<>();

	@OneToMany(mappedBy="donor", cascade=CascadeType.ALL)
	private Set<StudentEntity> donorStudentList = new HashSet<>();


}