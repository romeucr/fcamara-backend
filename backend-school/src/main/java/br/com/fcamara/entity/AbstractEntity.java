package br.com.fcamara.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "id")
	private Long id;

	@CreatedDate
	@Column
	private LocalDateTime creationDate;

	@CreatedBy
	@Column
	private String createdBy;

	@LastModifiedDate
	@Column
	private LocalDateTime lasModifiedDate;

	@LastModifiedBy
	@Column
	private String lasModifiedBy;

	public AbstractEntity(Long id) {
		this.id = id;
	}

	public AbstractEntity() {
	}

}
