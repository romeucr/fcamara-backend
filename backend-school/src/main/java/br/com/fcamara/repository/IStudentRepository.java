package br.com.fcamara.repository;

import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {

}
