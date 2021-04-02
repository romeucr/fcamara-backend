package br.com.fcamara.repository;

import br.com.fcamara.entity.SchoolEntity;
import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISchoolRepository extends JpaRepository<SchoolEntity, Long> {

  List<Optional<SchoolEntity>> findByNameContainingIgnoreCase(String name);

}
