package br.com.fcamara.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
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
	@Column(name = "email")
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String senha;
	
	@Column(name = "is_active")
	private boolean active = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name = "tb_user_role",
					joinColumns = @JoinColumn(name = "user_id"),
					inverseJoinColumns = @ JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet<>();
}
