package br.com.fcamara.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="tb_user")
@NoArgsConstructor
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -904241684393606265L;
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;
	
	@JsonInclude(Include.NON_EMPTY)
	@Column(name = "email")
	private String email;
	
	@JsonInclude(Include.NON_EMPTY)
	private String senha;
	
	@Column(name = "is_active")
	private boolean active = true;
	

}
