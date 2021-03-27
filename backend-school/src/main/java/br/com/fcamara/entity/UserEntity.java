package br.com.fcamara.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
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
	@Column(name = "email")
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String senha;
	
	@Column(name = "is_active")
	private boolean active = true;
	

}
