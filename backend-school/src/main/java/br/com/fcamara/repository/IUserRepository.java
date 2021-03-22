package br.com.fcamara.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fcamara.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("SELECT u FROM UserEntity u WHERE u.email = :email")
	Optional<UserEntity> findByEmail(@Param("email") String email);

}
