package br.com.fcamara.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_user", indexes = { @Index(name = "email_idx", columnList = "email") }, uniqueConstraints = {
		@UniqueConstraint(columnNames = { "email" }) })
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = -904241684393606265L;

	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "fullname")
	private String fullname;	
	
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

	private Set<RoleEntity> roles = new HashSet<RoleEntity>();

	@OneToOne
	@JoinColumn(name = "address_id")
	private AddressEntity address;

	@OneToMany(mappedBy="responsible", cascade=CascadeType.ALL)
	private Set<StudentEntity> responsibleStudentList = new HashSet<>();

	@OneToMany(mappedBy="donor", cascade=CascadeType.ALL)
	private Set<StudentEntity> donorStudentList = new HashSet<>();
}